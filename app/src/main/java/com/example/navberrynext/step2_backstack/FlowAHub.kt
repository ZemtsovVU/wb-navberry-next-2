package com.example.navberrynext.step2_backstack

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.navberrynext.shared.FlowAScreenA
import com.example.navberrynext.shared.FlowAScreenB
import java.util.Stack

private val backstack = Stack<String>()

@Composable
fun FlowAHubS2(
    modifier: Modifier,
    isBack: Boolean,
    onNextFlowClick: () -> Unit,
    onRequestFinish: () -> Unit,
) {
    var currentDest by remember {
        if (isBack) {
            val dest = backstack.pop()
            mutableStateOf(dest)
        } else {
            mutableStateOf("FlowAScreenA")
        }
    }

    when (currentDest) {
        "FlowAScreenA" -> {
            FlowAScreenA(
                modifier = modifier,
                onNextScreenClick = {
                    backstack.push(currentDest)
                    currentDest = "FlowAScreenB"
                },
            )
        }

        "FlowAScreenB" -> {
            FlowAScreenB(
                modifier = modifier,
                onNextFlowClick = {
                    // We need to push current destination only if we know that
                    // onNextFlowClick callback will lead to next destination.
                    // TODO How do we know that?
                    backstack.push(currentDest)
                    onNextFlowClick()
                },
            )
        }
    }

    // TODO DRY
    BackHandler {
        if (backstack.empty()) {
            onRequestFinish()
        } else {
            val dest = backstack.pop()
            currentDest = dest
        }
    }
}