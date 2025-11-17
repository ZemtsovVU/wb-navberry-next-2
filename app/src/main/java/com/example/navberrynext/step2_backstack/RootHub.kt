package com.example.navberrynext.step2_backstack

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.navberrynext.shared.RootScreenA
import com.example.navberrynext.shared.RootScreenB
import java.util.Stack

private val backstack = Stack<String>()

@Composable
fun RootHubS2(
    activity: Activity,
    modifier: Modifier,
    onRequestFinish: () -> Unit,
) {
    var currentDest by remember { mutableStateOf("RootScreenA") }
    var isBack by remember { mutableStateOf(false) }

    fun handleBack() {
        if (backstack.empty()) {
            onRequestFinish()
        } else {
            isBack = true
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
            FlowAHubS2(
                modifier = modifier,
                isBack = isBack,
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
                isBack = isBack,
                onButtonClick = {
                    Toast.makeText(
                        activity,
                        "FlowBScreenB button clicked",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                onRequestFinish = {
                    handleBack()
                },
            )
        }
    }
    isBack = false

    BackHandler {
        handleBack()
    }
}