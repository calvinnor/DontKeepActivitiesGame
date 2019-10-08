package com.calvinnor.dontkeepactivitiesgame.utils

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class DisableAnimationsRule : TestRule {

    private fun disableDeviceAnimations() {
        with(UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())) {
            writeSetting(TRANSITION_ANIMATION_SCALE, TYPE_GLOBAL, "0")
            writeSetting(ANIMATOR_DURATION_SCALE, TYPE_GLOBAL, "0")
            writeSetting(WINDOW_ANIMATION_SCALE, TYPE_GLOBAL, "0")
        }
    }

    override fun apply(base: Statement?, description: Description?) = object : Statement() {
        override fun evaluate() {
            disableDeviceAnimations()
            base?.evaluate()
        }
    }
}
