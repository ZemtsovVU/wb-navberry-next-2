package com.example.navberrynext.step3_nav_controller

class FlowAHubController : HubController("FlowAScreenA") {

    override fun navigateNext() {
        when (currentDest.value) {
            "FlowAScreenA" -> _currentDest.value = "FlowAScreenB"
            "FlowAScreenB" -> _currentDest.value = "RequestNextFlow"
        }
    }
}