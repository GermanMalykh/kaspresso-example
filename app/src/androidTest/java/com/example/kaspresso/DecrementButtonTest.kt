package com.example.kaspresso

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class DecrementButtonTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()
) {
    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun decrementButtonShouldDecreaseCounterValue() = run {
        step("Decrease counter value to 2") {
            MainScreen {
                repeat(2) {
                    decrementButton.click()
                }
            }
        }
        step("Counter value should be -2") {
            MainScreen {
                counterText.hasText("Count: -2")
            }
        }
    }

}