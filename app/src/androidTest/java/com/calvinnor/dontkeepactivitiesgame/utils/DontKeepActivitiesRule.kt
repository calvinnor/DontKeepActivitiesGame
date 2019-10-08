package com.calvinnor.dontkeepactivitiesgame.utils

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class DontKeepActivitiesRule : TestRule {

    private fun enableDontKeepActivities() {
        with(UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())) {
            writeSetting(DONT_KEEP_ACTIVITIES, TYPE_GLOBAL, "1")

            // If these are not enabled, the app can crash silently, which passes the tests
            writeSetting(SHOW_ANR_ON_BACKGROUND, TYPE_SECURE, "1")
            writeSetting(ALWAYS_SHOW_ANRS, TYPE_SECURE, "1")
        }
    }

    override fun apply(base: Statement?, description: Description?) = object : Statement() {
        override fun evaluate() {
            enableDontKeepActivities()
            base?.evaluate()
        }
    }
}
