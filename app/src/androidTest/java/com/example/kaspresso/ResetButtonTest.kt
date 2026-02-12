package com.example.kaspresso

import org.junit.Test

class ResetButtonTest : BaseKaspressoTest() {

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
                counterText.hasText("Count: 0")
            }
        }
    }

}