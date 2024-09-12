package com.tenextractor.redefinablekeyboard.feature_config.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tenextractor.redefinablekeyboard.R
import com.tenextractor.redefinablekeyboard.feature_config.SharedPrefsManager
import com.tenextractor.redefinablekeyboard.feature_config.HapticFeedbackService

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    val context = LocalContext.current
    val sharedPrefsManager = remember { SharedPrefsManager(context) }
    val hapticFeedbackService = remember { HapticFeedbackService(context) }

    var hapticFeedbackEnabled by remember { mutableStateOf(sharedPrefsManager.isHapticFeedbackEnabled()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.settings)) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(stringResource(R.string.haptic_feedback))
                Switch(
                    checked = hapticFeedbackEnabled,
                    onCheckedChange = {
                        hapticFeedbackEnabled = it
                        sharedPrefsManager.setHapticFeedbackEnabled(it)
                        if (it) {
                                hapticFeedbackService.performHapticFeedback()
                        }
                    }
                )
            }
        }
    }
}