// Copyright 2024 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.aws.toolkits.jetbrains.services.amazonqFeatureDev.session

import com.fasterxml.jackson.annotation.JsonValue
import software.aws.toolkits.jetbrains.services.amazonq.project.FeatureDevSessionContext
import software.aws.toolkits.jetbrains.services.amazonqFeatureDev.util.CancellationTokenSource
import software.aws.toolkits.jetbrains.services.amazonqFeatureDev.util.FeatureDevService
import software.aws.toolkits.jetbrains.services.cwc.messages.RecommendationContentSpan

data class SessionStateAction(
    val task: String,
    val msg: String,
    val token: CancellationTokenSource? = null,
)

data class Interaction(
    val content: String?,
    val interactionSucceeded: Boolean,
)

data class SessionStateInteraction<T : SessionState>(
    val nextState: T? = null,
    val interaction: Interaction,
)

enum class SessionStatePhase(
    @field:JsonValue val json: String,
) {
    INIT("Init"),
    CODEGEN("Codegen"),
}

data class SessionStateConfig(
    val conversationId: String,
    val repoContext: FeatureDevSessionContext,
    val featureDevService: FeatureDevService,
)

data class NewFileZipInfo(
    val zipFilePath: String,
    val fileContent: String,
    var rejected: Boolean,
    var changeApplied: Boolean,
)

data class DeletedFileInfo(
    val zipFilePath: String, // The string is the path of the file to be deleted
    var rejected: Boolean,
    var changeApplied: Boolean,
)

data class CodeGenerationResult(
    var newFiles: List<NewFileZipInfo>,
    var deletedFiles: List<DeletedFileInfo>,
    var references: List<CodeReferenceGenerated>,
    var codeGenerationRemainingIterationCount: Int? = null,
    var codeGenerationTotalIterationCount: Int? = null,
)

data class CodeReferenceGenerated(
    val licenseName: String? = null,
    val repository: String? = null,
    val url: String? = null,
    val recommendationContentSpan: RecommendationContentSpan? = null,
)

@Suppress("ConstructorParameterNaming") // Unfortunately, this is exactly how the string json is received and is needed for parsing.
data class CodeGenerationStreamResult(
    var new_file_contents: Map<String, String>,
    var deleted_files: List<String>,
    var references: List<CodeReferenceGenerated>,
)

@Suppress("ConstructorParameterNaming") // Unfortunately, this is exactly how the string json is received and is needed for parsing.
data class ExportTaskAssistResultArchiveStreamResult(
    var code_generation_result: CodeGenerationStreamResult,
)

data class DiffMetricsProcessed(
    var accepted: HashSet<String>,
    var generated: HashSet<String>,
)
