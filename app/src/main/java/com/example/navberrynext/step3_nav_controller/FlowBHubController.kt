package com.example.navberrynext.step3_nav_controller

class FlowBHubController : HubController("FlowBScreenA") {

    override fun navigateNext() {
        when (currentDest.value) {
            "FlowBScreenA" -> _currentDest.value = "FlowBScreenB"
        }
    }
}