package com.example.navberrynext.step4_nav_controller_2

class FlowAHubControllerS4 : HubControllerS4("FlowAScreenA") {

    override fun onCompleteInner(reason: String): Boolean {
        when (reason) {
            "FlowAScreenA_onNextScreenClicked" -> _currentDest.value = "FlowAScreenB"
            "FlowAScreenB_onNextFlowClicked" -> _currentDest.value = "RequestNextFlow"
            else -> error("Unknown reason")
        }
        return true
    }
}