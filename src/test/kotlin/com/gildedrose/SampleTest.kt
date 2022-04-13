package com.gildedrose

import org.approvaltests.Approvals
import org.approvaltests.JsonApprovals
import org.approvaltests.combinations.CombinationApprovals
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SampleTests {
    @Test
    fun testNormalJunit() {
        Assertions.assertEquals(5, 5)
    }

    @Test
    fun testWithApprovalTests() {
        Approvals.verify("Hello World")
    }

    @Test
    fun testCombinations() {
        val numbers = arrayOf(10, 20, 30, 40, 50)
        CombinationApprovals.verifyAllCombinations({ a, b -> "$a + $b" }, numbers, numbers)
    }

    /**
     * note: this requires GSON which is currently added in the pom.xml file.
     * This is only required if you want to use the VerifyAsJson.
     */
    @Test
    fun testJson() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        JsonApprovals.verifyAsJson(app.items[0])
    }
}