// Copyright 2024 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.aws.toolkits.jetbrains.services.amazonqFeatureDev

const val FEATURE_EVALUATION_PRODUCT_NAME = "FeatureDev"

const val FEATURE_NAME = "Amazon Q Developer Agent for software development"

// Max number of times a user can attempt to retry a code generation request if it fails
const val CODE_GENERATION_RETRY_LIMIT = 3

// The default retry limit used when the session could not be found
const val DEFAULT_RETRY_LIMIT = 0

// Max allowed size for a repository in bytes
const val MAX_PROJECT_SIZE_BYTES: Long = 200 * 1024 * 1024

enum class ModifySourceFolderErrorReason(
    private val reasonText: String,
) {
    ClosedBeforeSelection("ClosedBeforeSelection"),
    NotInWorkspaceFolder("NotInWorkspaceFolder"),
    ;

    override fun toString(): String = reasonText
}

enum class FeatureDevOperation(private val operationName: String) {
    StartTaskAssistCodeGeneration("StartTaskAssistCodeGenerator"),
    CreateConversation("CreateConversation"),
    CreateUploadUrl("CreateUploadUrl"),
    GenerateCode("GenerateCode"),
    GetTaskAssistCodeGeneration("GetTaskAssistCodeGenerator"),
    ExportTaskAssistArchiveResult("ExportTaskAssistArchiveResult"),
    UploadToS3("UploadToS3"),
    ;

    override fun toString(): String = operationName
}

enum class MetricDataOperationName(private val operationName: String) {
    StartCodeGeneration("StartCodeGeneration"),
    EndCodeGeneration("EndCodeGeneration"),
    ;

    override fun toString(): String = operationName
}

enum class MetricDataResult(private val resultName: String) {
    Success("Success"),
    Fault("Fault"),
    Error("Error"),
    LlmFailure("LLMFailure"),
    ;

    override fun toString(): String = resultName
}
