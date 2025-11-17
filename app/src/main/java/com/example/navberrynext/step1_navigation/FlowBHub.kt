package com.example.navberrynext.step1_navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.navberrynext.shared.FlowBScreenA
import com.example.navberrynext.shared.FlowBScreenB

@Composable
fun FlowBHubS1(
    modifier: Modifier,
    onButtonClick: () -> Unit,
) {
    var currentDest by remember { mutableStateOf("FlowBScreenA") }

    when (currentDest) {
        "FlowBScreenA" -> {
            FlowBScreenA(
                modifier = modifier,
                onNextScreenClick = {
                    currentDest = "FlowBScreenB"
                },
            )
        }

        "FlowBScreenB" -> {
            FlowBScreenB(
                modifier = modifier,
                onButtonClick = {
                    onButtonClick()
                },
            )
        }
    }
}