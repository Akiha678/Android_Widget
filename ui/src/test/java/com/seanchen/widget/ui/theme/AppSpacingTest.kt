package com.seanchen.widget.ui.theme

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AppSpacingTest {
    @Test
    fun spacingScale_isStrictlyIncreasing() {
        val spacing = AppSpacing()
        val values = listOf(
            spacing.none,
            spacing.extraSmall,
            spacing.small,
            spacing.medium,
            spacing.large,
            spacing.extraLarge,
            spacing.huge,
        )

        assertTrue(values.zipWithNext().all { (left, right) -> left < right })
    }

    @Test
    fun spacingScale_hasExpectedBaseGrid() {
        val spacing = AppSpacing()

        assertEquals(0, spacing.none.value.toInt())
        assertEquals(4, spacing.extraSmall.value.toInt())
        assertEquals(8, spacing.small.value.toInt())
    }
}
