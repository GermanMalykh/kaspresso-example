package com.example.kaspresso

import org.junit.Test

class DecrementButtonTest : BaseKaspressoTest() {

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