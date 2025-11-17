package com.example.navberrynext.step1_navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.navberrynext.shared.FlowAScreenA
import com.example.navberrynext.shared.FlowAScreenB

@Composable
fun FlowAHubS1(
    modifier: Modifier,
    onNextFlowClick: () -> Unit,
) {
    var currentDest by remember { mutableStateOf("FlowAScreenA") }

    when (currentDest) {
        "FlowAScreenA" -> {
            FlowAScreenA(
                modifier = modifier,
                onNextScreenClick = {
                    currentDest = "FlowAScreenB"
                },
            )
        }

        "FlowAScreenB" -> {
            FlowAScreenB(
                modifier = modifier,
                onNextFlowClick = {
                    onNextFlowClick()
                },
            )
        }
    }
}