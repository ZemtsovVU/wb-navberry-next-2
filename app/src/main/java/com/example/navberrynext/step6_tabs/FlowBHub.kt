package com.example.navberrynext.step6_tabs

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.navberrynext.shared.FlowBScreenA
import com.example.navberrynext.shared.FlowBScreenB

@Composable
fun FlowBHubS6(
    controller: FlowBHubControllerS6,
    modifier: Modifier,
    onButtonClick: () -> Unit,
    onRequestFinish: () -> Unit,
) {
    val currentDest = controller.currentDest.collectAsState()

    print("FlowBHub currentDest = ${currentDest.value}\n")

    when (currentDest.value) {
        "FlowBScreenA" -> {
            FlowBScreenA(
                modifier = modifier,
                onNextScreenClick = {
                    controller.onComplete("FlowBScreenA_onNextScreenClicked")
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

        "RequestFinish" -> {
            onRequestFinish()
        }
    }

    BackHandler {
        controller.onBack()
    }
}