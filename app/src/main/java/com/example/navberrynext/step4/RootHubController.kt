package com.example.navberrynext.step4

import com.example.navberrynext.shared.step3.HubController

class RootHubControllerS4 : HubController("RootScreenA") {

    // TODO We can use factory to encapsulate this
    private var _flowAController: FlowAHubControllerS4? = null
    val flowAController: FlowAHubControllerS4
        get() {
            if (_flowAController == null) {
                _flowAController = FlowAHubControllerS4()
            }
            return _flowAController!!
        }

    private var _flowBController: FlowBHubControllerS4? = null
    val flowBController: FlowBHubControllerS4
        get() {
            if (_flowBController == null) {
                _flowBController = FlowBHubControllerS4()
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