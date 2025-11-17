package com.example.navberrynext.shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun RootScreenA(
    modifier: Modifier,
    onNextScreenClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = "RootScreenA",
        )
        Button(
            onClick = {
                onNextScreenClick()
            },
        ) {
            Text(
                text = "To RootScreenB",
            )
        }
    }
}

@Composable
internal fun RootScreenB(
    modifier: Modifier,
    onNextFlowClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = "RootScreenB",
        )
        Button(
            onClick = {
                onNextFlowClick()
            },
        ) {
            Text(
                text = "To FlowAScreenA",
            )
        }
    }
}