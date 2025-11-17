package com.example.navberrynext.shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FlowBScreenA(
    modifier: Modifier,
    onNextScreenClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = "FlowBScreenA",
        )
        Button(
            onClick = {
                onNextScreenClick()
            },
        ) {
            Text(
                text = "To FlowBScreenB",
            )
        }
    }
}

@Composable
fun FlowBScreenB(
    modifier: Modifier,
    onButtonClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = "FlowBScreenB",
        )
        Button(
            onClick = {
                onButtonClick()
            },
        ) {
            Text(
                text = "NoOp",
            )
        }
    }
}