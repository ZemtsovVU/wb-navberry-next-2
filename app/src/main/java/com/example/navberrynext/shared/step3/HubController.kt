package com.example.navberrynext.shared.step3

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Stack

@Suppress("MemberVisibilityCanBePrivate", "PropertyName")
abstract class HubController(private val initialDest: String) {

    protected val backstack = Stack<String>()

    protected val _currentDest = MutableStateFlow(initialDest)
    val currentDest: StateFlow<String> = _currentDest.asStateFlow()

    fun onStart() {
        if (backstack.empty()) {
            _currentDest.value = initialDest
        } else {
            _currentDest.value = backstack.pop()
        }
    }

    fun navigateForward() {
        backstack.push(currentDest.value)
        navigateNext()
    }

    protected abstract fun navigateNext()

    fun navigateBackward() {
        if (backstack.empty()) {
            _currentDest.value = "RequestFinish"
        } else {
            val prevDest = backstack.pop()
            onNavigateBackward(currentDest.value, prevDest)
            _currentDest.value = prevDest
        }
    }

    protected open fun onNavigateBackward(
        currentDest: String,
        previousDest: String,
    ) = Unit
}