package com.example.kaspresso

import org.junit.Test

class IncrementButtonTest : BaseKaspressoTest() {

    @Test
    fun incrementButtonShouldIncreaseCounterValue() = run {
        step("Increase counter value to 2") {
            MainScreen {
                repeat(2) {
                    incrementButton.click()
                }
            }
        }
        step("Counter value should be 2") {
            MainScreen {
                counterText.hasText("Count: 2")
            }
        }
    }

}