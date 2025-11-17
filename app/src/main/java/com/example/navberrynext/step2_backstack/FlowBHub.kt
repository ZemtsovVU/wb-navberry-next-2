package com.example.navberrynext.step2_backstack

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.navberrynext.shared.FlowBScreenA
import com.example.navberrynext.shared.FlowBScreenB
import java.util.Stack

private val backstack = Stack<String>()

@Composable
fun FlowBHubS2(
    modifier: Modifier,
    isBack: Boolean,
    onButtonClick: () -> Unit,
    onRequestFinish: () -> Unit,
) {
    // TODO DRY
    var currentDest by remember {
        if (isBack) {
            val dest = backstack.pop()
            mutableStateOf(dest)
        } else {
            mutableStateOf("FlowBScreenA")
        }
    }

    when (currentDest) {
        "FlowBScreenA" -> {
            FlowBScreenA(
                modifier = modifier,
                onNextScreenClick = {
                    backstack.push(currentDest)
                    currentDest = "FlowBScreenB"
                },
            )
        }

        "FlowBScreenB" -> {
            FlowBScreenB(
                modifier = modifier,
                onButtonClick = {
                    // But here we don't push current destination because we
                    // don't know what exactly will happen.
                    // TODO How to handle this situation in common?
                    onButtonClick()
                },
            )
        }
    }

    BackHandler {
        if (backstack.empty()) {
            onRequestFinish()
        } else {
            val dest = backstack.pop()
            currentDest = dest
        }
    }
}