package com.example.navberrynext.step3_nav_controller

class FlowBHubControllerS3 : HubControllerS3("FlowBScreenA") {

    override fun navigateNext() {
        when (currentDest.value) {
            "FlowBScreenA" -> _currentDest.value = "FlowBScreenB"
        }
    }
}