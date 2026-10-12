package com.hyperos.dialer.data

// Mock data models for dialer features

data class CallRecording(
    val id: String,
    val contactName: String,
    val duration: Long,
    val timestamp: Long,
    val filePath: String
)

data class VoiceMailMessage(
    val id: String,
    val contactName: String,
    val duration: Long,
    val timestamp: Long,
    val isNew: Boolean
)

data class BlockedNumber(
    val id: String,
    val number: String,
    val name: String?,
    val dateAdded: Long
)

data class DialerSettings(
    val callWaitingEnabled: Boolean = true,
    val callRecordingEnabled: Boolean = true,
    val showCallerId: Boolean = true,
    val blockSpamCalls: Boolean = true,
    val voiceMailNumber: String? = null
)
