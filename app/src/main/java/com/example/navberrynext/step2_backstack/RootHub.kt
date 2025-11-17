package com.example.navberrynext.step2_backstack

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.navberrynext.shared.RootScreenA
import com.example.navberrynext.shared.RootScreenB
import java.util.Stack

private val backstack = Stack<String>()

@Composable
fun RootHubS2(
    modifier: Modifier,
    onRequestFinish: () -> Unit,
) {
    var currentDest by remember { mutableStateOf("RootScreenA") }

    fun handleBack() {
        if (backstack.empty()) {
            onRequestFinish()
        } else {
            val dest = backstack.pop()
            currentDest = dest
        }
    }

    when (currentDest) {
        "RootScreenA" -> {
            RootScreenA(
                modifier = modifier,
                onNextScreenClick = {
                    backstack.push(currentDest)
                    currentDest = "RootScreenB"
                },
            )
        }

        "RootScreenB" -> {
            RootScreenB(
                modifier = modifier,
                onNextFlowClick = {
                    backstack.push(currentDest)
                    currentDest = "RootFlowA"
                },
            )
        }

        "RootFlowA" -> {
            // TODO We need to provide some info to child hub about required
            //  action, e.g. launch, back, or exact screen. Should root hub
            //  have knowledge about child hub flow?
            FlowAHubS2(
                modifier = modifier,
                onNextFlowClick = {
                    // TODO DRY
                    backstack.push(currentDest)
                    currentDest = "RootFlowB"
                },
                onRequestFinish = {
                    handleBack()
                },
            )
        }

        "RootFlowB" -> {
            FlowBHubS2(
                modifier = modifier,
                onButtonClick = { /* do nothing */ },
                onRequestFinish = {
                    handleBack()
                },
            )
        }
    }

    BackHandler {
        handleBack()
    }
}