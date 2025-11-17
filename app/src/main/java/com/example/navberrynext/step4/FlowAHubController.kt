package com.example.navberrynext.step4

import com.example.navberrynext.shared.step3.HubController

class FlowAHubControllerS4 : HubController("FlowAScreenA") {

    override fun navigateNext() {
        when (currentDest.value) {
            "FlowAScreenA" -> _currentDest.value = "FlowAScreenB"
            "FlowAScreenB" -> _currentDest.value = "RequestNextFlow"
        }
    }
}