package com.example.navberrynext.step6_tabs

class FlowBHubControllerS6 : HubControllerS6("FlowBScreenA") {

    override fun onCompleteInner(reason: String): Boolean {
        when (reason) {
            "FlowBScreenA_onNextScreenClicked" -> _currentDest.value = "FlowBScreenB"
            else -> error("Unknown reason")
        }
        return true
    }
}