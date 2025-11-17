package com.example.navberrynext.step4_nav_controller_2

class FlowBHubControllerS4 : HubControllerS4("FlowBScreenA") {

    override fun onCompleteInner(reason: String): Boolean {
        when (reason) {
            "FlowBScreenA_onNextScreenClicked" -> _currentDest.value = "FlowBScreenB"
            else -> error("Unknown reason")
        }
        return true
    }
}