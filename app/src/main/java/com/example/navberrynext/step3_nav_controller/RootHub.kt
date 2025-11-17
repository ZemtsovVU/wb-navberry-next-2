package com.example.navberrynext.step3_nav_controller

import android.content.Context
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.navberrynext.shared.RootScreenA
import com.example.navberrynext.shared.RootScreenB

@Composable
fun RootHubS3(
    controller: RootHubController,
    context: Context,
    modifier: Modifier,
    onRequestFinish: () -> Unit,
) {
    // TODO It will be better to call onStart from here
    //  or even on new subscription on currentDest.
    //LifecycleEventEffect(Lifecycle.Event.ON_CREATE) {
    //    controller.onStart()
    //}

    val currentDest = controller.currentDest.collectAsState()

    when (currentDest.value) {
        "RootScreenA" -> {
            RootScreenA(
                modifier = modifier,
                onNextScreenClick = {
                    controller.navigateForward()
                },
            )
        }

        "RootScreenB" -> {
            RootScreenB(
                modifier = modifier,
                onNextFlowClick = {
                    controller.navigateForward()
                },
            )
        }

        "RootFlowA" -> {
            FlowAHubS3(
                controller = controller.flowAController,
                modifier = modifier,
                onNextFlowClick = {
                    controller.navigateForward()
                },
                onRequestFinish = {
                    controller.navigateBackward()
                },
            )
        }

        "RootFlowB" -> {
            FlowBHubS3(
                controller = controller.flowBController,
                modifier = modifier,
                onButtonClick = {
                    Toast.makeText(
                        context,
                        "FlowBScreenB button clicked",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                onRequestFinish = {
                    controller.navigateBackward()
                },
            )
        }

        "RequestFinish" -> {
            onRequestFinish()
        }
    }

    BackHandler {
        controller.navigateBackward()
    }
}