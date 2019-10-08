package com.calvinnor.dontkeepactivitiesgame.utils

import androidx.test.uiautomator.UiDevice

fun UiDevice.writeSetting(settingKey: String, settingType: String, value: String): String =
    executeShellCommand("settings put $settingType $settingKey $value")
