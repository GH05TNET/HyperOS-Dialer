package com.hyperos.dialer.ui.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CallMissed
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CallRecord(
    val name: String,
    val number: String,
    val time: String,
    val duration: String,
    val callType: CallType
)

enum class CallType {
    INCOMING, OUTGOING, MISSED, REJECTED
}

@Composable
fun CallHistoryTab() {
    val callHistory = listOf(
        CallRecord("Sarah Smith", "+1 234 567 890", "Today 2:45 PM", "3m 25s", CallType.OUTGOING),
        CallRecord("Unknown Number", "+1 333 444 555", "Today 1:20 PM", "--", CallType.MISSED),
        CallRecord("John Doe", "+1 987 654 321", "Yesterday 5:10 PM", "12m 5s", CallType.INCOMING),
        CallRecord("Emily Johnson", "+1 555 123 456", "2 days ago", "8m 30s", CallType.OUTGOING),
        CallRecord("Mom", "+1 777 888 999", "3 days ago", "15m", CallType.INCOMING),
        CallRecord("Spam Call", "+1 444 555 666", "3 days ago", "--", CallType.REJECTED),
        CallRecord("Mike Wilson", "+1 666 789 012", "1 week ago", "2m 10s", CallType.INCOMING)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0B1020))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Recents",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF1B273E))
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(callHistory) { record ->
                Surface(
                    color = Color(0xFF0E1a2d),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { }
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(
                                    when (record.callType) {
                                        CallType.MISSED, CallType.REJECTED -> Color(0xFF3B2820)
                                        else -> Color(0xFF1B273E)
                                    }
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = when (record.callType) {
                                    CallType.MISSED, CallType.REJECTED -> Icons.Default.CallMissed
                                    else -> Icons.Default.Person
                                },
                                contentDescription = null,
                                tint = when (record.callType) {
                                    CallType.MISSED, CallType.REJECTED -> Color(0xFFEA5050)
                                    else -> Color(0xFF4DA3FF)
                                },
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = record.name,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 15.sp
                            )
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = record.number,
                                    color = Color(0xFF8A99B0),
                                    fontSize = 12.sp
                                )
                                Text(
                                    text = "•",
                                    color = Color(0xFF5A6B85),
                                    fontSize = 12.sp
                                )
                                Text(
                                    text = record.time,
                                    color = Color(0xFF5A6B85),
                                    fontSize = 12.sp
                                )
                            }
                            Text(
                                text = record.duration,
                                color = Color(0xFF5A6B85),
                                fontSize = 11.sp
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF2FC39A))
                                .clickable { },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
