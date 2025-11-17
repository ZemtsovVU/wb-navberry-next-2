package com.example.navberrynext.step4

import com.example.navberrynext.shared.step3.HubController

class FlowBHubControllerS4 : HubController("FlowBScreenA") {

    override fun navigateNext() {
        when (currentDest.value) {
            "FlowBScreenA" -> _currentDest.value = "FlowBScreenB"
        }
    }
}