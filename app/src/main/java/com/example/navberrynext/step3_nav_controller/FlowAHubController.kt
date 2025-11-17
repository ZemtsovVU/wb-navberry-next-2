package com.example.navberrynext.step3_nav_controller

class FlowAHubControllerS3 : HubControllerS3("FlowAScreenA") {

    override fun navigateNext() {
        when (currentDest.value) {
            "FlowAScreenA" -> _currentDest.value = "FlowAScreenB"
            "FlowAScreenB" -> _currentDest.value = "RequestNextFlow"
        }
    }
}