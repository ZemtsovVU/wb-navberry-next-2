package com.example.navberrynext.step5_nav_animations

class RootHubControllerS5 : HubControllerS5("RootScreenA") {

    // TODO We can use factory to encapsulate this
    private var _flowAController: FlowAHubControllerS5? = null
    val flowAController: FlowAHubControllerS5
        get() {
            if (_flowAController == null) {
                _flowAController = FlowAHubControllerS5()
            }
            return _flowAController!!
        }

    private var _flowBController: FlowBHubControllerS5? = null
    val flowBController: FlowBHubControllerS5
        get() {
            if (_flowBController == null) {
                _flowBController = FlowBHubControllerS5()
            }
            return _flowBController!!
        }

    override fun onCompleteInner(reason: String): Boolean {
        when (reason) {
            "RootScreenA_onNextScreenClicked" -> _currentDest.value = "RootScreenB"
            "RootScreenB_onNextFlowClicked" -> _currentDest.value = "RootFlowA"
            "RootFlowA_onNextFlowClicked" -> _currentDest.value = "RootFlowB"
            else -> error("Unknown reason")
        }
        return true
    }

    //fun onRootScreenAOnNextScreenClicked() {
    //    backstack.push(currentDest.value)
    //    _currentDest.value = "RootScreenB"
    //}

    override fun onBackInner(
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