package com.example.navberrynext.step5_nav_animations

class FlowAHubControllerS5 : HubControllerS5("FlowAScreenA") {

    override fun onCompleteInner(reason: String): Boolean {
        when (reason) {
            "FlowAScreenA_onNextScreenClicked" -> _currentDest.value = "FlowAScreenB"
            "FlowAScreenB_onNextFlowClicked" -> _currentDest.value = "RequestNextFlow"
            else -> error("Unknown reason")
        }
        return true
    }
}