package com.example.navberrynext.step5_nav_animations_incomplete

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Stack

@Suppress("MemberVisibilityCanBePrivate", "PropertyName")
abstract class HubControllerS5(private val initialDest: String) {

    protected val backstack = Stack<String>()

    protected val _currentDest = MutableStateFlow(initialDest)
    val currentDest: StateFlow<String> = _currentDest.asStateFlow()

    protected val _currentDestData = MutableStateFlow(
        DestData(
            prevDest = "",
            fromDest = "",
            toDest = initialDest
        )
    )
    val currentDestData: StateFlow<DestData> = _currentDestData.asStateFlow()

    fun onStart() {
        if (backstack.empty()) {
            _currentDest.value = initialDest
        } else {
            _currentDest.value = backstack.pop()
        }
    }

    fun onComplete(reason: String) {
        val prevDest = currentDest.value
        val shouldPushToBackstack = onCompleteInner(reason)
        if (shouldPushToBackstack) backstack.push(prevDest)
    }

    protected abstract fun onCompleteInner(reason: String): Boolean

    fun onBack() {
        if (backstack.empty()) {
            _currentDest.value = "RequestFinish"
        } else {
            val prevDest = backstack.pop()
            onBackInner(currentDest.value, prevDest)
            _currentDest.value = prevDest
        }
    }

    protected open fun onBackInner(
        currentDest: String,
        previousDest: String,
    ) = Unit
}

data class DestData(
    // for iPhone-like back gesture
    val prevDest: String,

    val fromDest: String,
    val toDest: String,
    val direction: DestDirection = DestDirection.FORWARD,
)

enum class DestDirection {
    FORWARD,
    BACKWARD,
}