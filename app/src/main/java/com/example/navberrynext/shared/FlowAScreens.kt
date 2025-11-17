package com.example.navberrynext.shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun FlowAScreenA(
    modifier: Modifier,
    onNextScreenClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = "FlowAScreenA",
        )
        Button(
            onClick = {
                onNextScreenClick()
            },
        ) {
            Text(
                text = "To FlowAScreenB",
            )
        }
    }
}

@Composable
internal fun FlowAScreenB(
    modifier: Modifier,
    onNextFlowClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = "FlowAScreenB",
        )
        Button(
            onClick = {
                onNextFlowClick()
            },
        ) {
            Text(
                text = "To FlowBScreenA",
            )
        }
    }
}