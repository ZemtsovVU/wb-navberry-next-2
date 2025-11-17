package com.example.navberrynext.step3_nav_controller

class RootHubController : HubController("RootScreenA") {

    // TODO We can use factory to encapsulate this
    private var _flowAController: FlowAHubController? = null
    val flowAController: FlowAHubController
        get() {
            if (_flowAController == null) {
                _flowAController = FlowAHubController()
            }
            return _flowAController!!
        }

    private var _flowBController: FlowBHubController? = null
    val flowBController: FlowBHubController
        get() {
            if (_flowBController == null) {
                _flowBController = FlowBHubController()
            }
            return _flowBController!!
        }

    // TODO How should we understand which next direction to choose?
    override fun navigateNext() {
        when (currentDest.value) {
            "RootScreenA" -> _currentDest.value = "RootScreenB"
            "RootScreenB" -> _currentDest.value = "RootFlowA"
            "RootFlowA" -> _currentDest.value = "RootFlowB"
        }
    }

    override fun onNavigateBackward(
        currentDest: String,
        previousDest: String,
    ) {
        // TODO Manage this mess
        // Maybe move to abstract HubController?
        releaseChildController(currentDest)
        signalChildController(previousDest)
    }

    private fun releaseChildController(dest: String) {
        when (dest) {
            "RootFlowA" -> _flowAController = null
            "RootFlowB" -> _flowBController = null
        }
    }

    private fun signalChildController(dest: String) {
        when (dest) {
            "RootFlowA" -> _flowAController!!.onStart()
            "RootFlowB" -> _flowBController!!.onStart()
        }
    }
}