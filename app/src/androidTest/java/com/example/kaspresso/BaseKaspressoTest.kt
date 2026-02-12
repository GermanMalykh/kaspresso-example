package com.example.kaspresso

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule

abstract class BaseKaspressoTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()
) {
    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()
}
