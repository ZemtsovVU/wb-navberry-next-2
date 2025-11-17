package com.example.navberrynext.step5_nav_animations

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.navberrynext.shared.FlowAScreenA
import com.example.navberrynext.shared.FlowAScreenB

@Composable
fun FlowAHubS5(
    controller: FlowAHubControllerS5,
    modifier: Modifier,
    onNextFlowClick: () -> Unit,
    onRequestFinish: () -> Unit,
) {
    val currentDest = controller.currentDest.collectAsState()

    print("FlowAHub currentDest = ${currentDest.value}\n")

    when (currentDest.value) {
        "FlowAScreenA" -> {
            FlowAScreenA(
                modifier = modifier,
                onNextScreenClick = {
                    controller.onComplete("FlowAScreenA_onNextScreenClicked")
                },
            )
        }

        "FlowAScreenB" -> {
            FlowAScreenB(
                modifier = modifier,
                onNextFlowClick = {
                    controller.onComplete("FlowAScreenB_onNextFlowClicked")
                },
            )
        }

        "RequestNextFlow" -> {
            onNextFlowClick()
        }

        "RequestFinish" -> {
            onRequestFinish()
        }
    }

    BackHandler {
        controller.onBack()
    }
}