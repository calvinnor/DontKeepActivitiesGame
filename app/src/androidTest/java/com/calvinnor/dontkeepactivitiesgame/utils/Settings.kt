package com.calvinnor.dontkeepactivitiesgame.utils

import android.provider.Settings

const val TYPE_GLOBAL = "global"
const val TYPE_SECURE = "secure"

const val DONT_KEEP_ACTIVITIES = Settings.Global.ALWAYS_FINISH_ACTIVITIES
const val SHOW_ANR_ON_BACKGROUND = "anr_show_background"
const val ALWAYS_SHOW_ANRS = "show_first_crash_dialog_dev_option"

// Animations
const val TRANSITION_ANIMATION_SCALE = "transition_animation_scale"
const val ANIMATOR_DURATION_SCALE = "animator_duration_scale"
const val WINDOW_ANIMATION_SCALE = "window_animation_scale"
