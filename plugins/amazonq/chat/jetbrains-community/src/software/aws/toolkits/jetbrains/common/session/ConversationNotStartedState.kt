// Copyright 2024 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.aws.toolkits.jetbrains.common.session

import software.aws.toolkits.jetbrains.services.amazonqDoc.session.SessionStateInteraction
import software.aws.toolkits.jetbrains.services.amazonqFeatureDev.session.SessionStateAction
import software.aws.toolkits.jetbrains.services.amazonqFeatureDev.session.SessionStatePhase
import software.aws.toolkits.jetbrains.services.amazonqFeatureDev.util.CancellationTokenSource

class ConversationNotStartedState(
    override var approach: String,
    override val tabID: String,
    override var token: CancellationTokenSource?,
) : SessionState {
    override val phase = SessionStatePhase.INIT

    override suspend fun interact(action: SessionStateAction): SessionStateInteraction<SessionState> {
        error("Illegal transition between states, restart the conversation")
    }
}