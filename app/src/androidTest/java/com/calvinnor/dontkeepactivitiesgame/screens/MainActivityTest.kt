package com.calvinnor.dontkeepactivitiesgame.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import com.calvinnor.dontkeepactivitiesgame.R
import com.calvinnor.dontkeepactivitiesgame.ui.MainActivity
import com.calvinnor.dontkeepactivitiesgame.utils.DisableAnimationsRule
import com.calvinnor.dontkeepactivitiesgame.utils.DontKeepActivitiesRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val disableAnimationsRule = DisableAnimationsRule()

    @get:Rule
    val dontKeepActivitiesRule = DontKeepActivitiesRule()

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun givenAndroidLauncher_clickingOnAppIconOpensTheMainActivity() {
        // A Successful execution means our App didn't crash on open
    }

    @Test
    fun givenAppOpened_andPlayerDetailsEntered_thenGameScreenIsShown() {
        navigateToGameScreen()
    }

    @Test
    fun givenGameScreen_andPlayerScoresMaintained_thenAppDoesNotCrashWhenBackgroundAndForeground() {
        navigateToGameScreen()

        // Increment scores
        onView(withId(R.id.ivPlayerOneAddScore)).perform(click())
        onView(withId(R.id.ivPlayerTwoAddScore)).perform(click())

        with(UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())) {

            // Go to background
            pressHome()

            // And back to foreground
            pressRecentApps()
            findObject(UiSelector().description("Dont Keep Activities Game")).click()
        }
    }

    private fun navigateToGameScreen() {
        onView(withId(R.id.etPlayer1Name))
            .perform(clearText())
            .perform(typeText("Test Player 1"))

        onView(withId(R.id.etPlayer2Name))
            .perform(clearText())
            .perform(typeText("Test Player 2"))
            .perform(closeSoftKeyboard())

        onView(withId(R.id.btnPlay)).perform(click())
    }
}
