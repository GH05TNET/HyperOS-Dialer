package com.hyperos.dialer.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hyperos.dialer.ui.components.DialerBottomNavigation
import com.hyperos.dialer.ui.tabs.DialPadTab
import com.hyperos.dialer.ui.tabs.CallHistoryTab
import com.hyperos.dialer.ui.tabs.ContactsTab
import com.hyperos.dialer.ui.tabs.FavoritesTab

@Composable
fun MainDialerScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0B1020)),
        bottomBar = {
            DialerBottomNavigation(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0B1020))
                .padding(innerPadding)
        ) {
            when (selectedTab) {
                0 -> DialPadTab()
                1 -> FavoritesTab()
                2 -> CallHistoryTab()
                3 -> ContactsTab()
            }
        }
    }
}
