package com.example.navberrynext.step3_nav_controller

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.navberrynext.shared.FlowAScreenA
import com.example.navberrynext.shared.FlowAScreenB

@Composable
fun FlowAHubS3(
    controller: FlowAHubController,
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
                    controller.navigateForward()
                },
            )
        }

        "FlowAScreenB" -> {
            FlowAScreenB(
                modifier = modifier,
                onNextFlowClick = {
                    controller.navigateForward()
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
        controller.navigateBackward()
    }
}