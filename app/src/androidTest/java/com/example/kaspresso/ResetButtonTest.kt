package com.example.kaspresso

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class ResetButtonTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()
) {
    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun counterTextShouldHaveDefaultValue() = run {
        step("Decrease counter value to 2") {
            MainScreen {
                repeat(2) {
                    decrementButton.click()
                }
            }
        }
        step("Reset counter value") {
            MainScreen {
                resetButton.click()
            }
        }
        step("Counter value should be 0") {
            MainScreen {
                counterText.hasText("Count: 1")
            }
        }
    }

}