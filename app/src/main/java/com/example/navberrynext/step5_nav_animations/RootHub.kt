package com.example.navberrynext.step5_nav_animations

import android.content.Context
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.navberrynext.shared.RootScreenA
import com.example.navberrynext.shared.RootScreenB

@Composable
fun RootHubS5(
    controller: RootHubControllerS5,
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
                    controller.onComplete("RootScreenA_onNextScreenClicked")
                    //controller.onRootScreenAOnNextScreenClicked()
                },
            )
        }

        "RootScreenB" -> {
            RootScreenB(
                modifier = modifier,
                onNextFlowClick = {
                    controller.onComplete("RootScreenB_onNextFlowClicked")
                },
            )
        }

        "RootFlowA" -> {
            FlowAHubS5(
                // TODO We can use factory to encapsulate this
                controller = controller.flowAController,
                modifier = modifier,
                onNextFlowClick = {
                    controller.onComplete("RootFlowA_onNextFlowClicked")
                },
                onRequestFinish = {
                    controller.onBack()
                },
            )
        }

        "RootFlowB" -> {
            FlowBHubS5(
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
                    controller.onBack()
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