package com.example.navberrynext.step1_navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.navberrynext.shared.RootScreenA
import com.example.navberrynext.shared.RootScreenB

@Composable
fun RootHubS1(
    modifier: Modifier,
) {
    var currentDest by remember { mutableStateOf("RootScreenA") }

    when (currentDest) {
        "RootScreenA" -> {
            RootScreenA(
                modifier = modifier,
                onNextScreenClick = {
                    currentDest = "RootScreenB"
                },
            )
        }

        "RootScreenB" -> {
            RootScreenB(
                modifier = modifier,
                onNextFlowClick = {
                    currentDest = "RootFlowA"
                },
            )
        }

        "RootFlowA" -> {
            FlowAHubS1(
                modifier = modifier,
                onNextFlowClick = {
                    currentDest = "RootFlowB"
                },
            )
        }

        "RootFlowB" -> {
            FlowBHubS1(
                modifier = modifier,
                onButtonClick = { /* do nothing */ },
            )
        }
    }
}