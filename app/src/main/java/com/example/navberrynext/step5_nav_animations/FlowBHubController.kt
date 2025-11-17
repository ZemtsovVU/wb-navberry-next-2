package com.example.navberrynext.step5_nav_animations

class FlowBHubControllerS5 : HubControllerS5("FlowBScreenA") {

    override fun onCompleteInner(reason: String): Boolean {
        when (reason) {
            "FlowBScreenA_onNextScreenClicked" -> _currentDest.value = "FlowBScreenB"
            else -> error("Unknown reason")
        }
        return true
    }
}