package com.nalin.datastructurealgorithm.problem

import com.nalin.datastructurealgorithm.ds.linkedListOf
import com.nalin.datastructurealgorithm.problems.checkIntervalOveralps
import com.nalin.datastructurealgorithm.problems.firstDuplicateValue
import com.nalin.datastructurealgorithm.problems.linkedListPalindrome
import com.nalin.datastructurealgorithm.problems.mergeOverlappingIntervals
import kotlin.test.Test
import kotlin.test.assertEquals

class AE_List_Test {

    @Test
    fun testCheckIntervalOveralps() {
        assertEquals(checkIntervalOveralps(listOf(1, 3), listOf(2, 4)), true)
        assertEquals(checkIntervalOveralps(listOf(1, 2), listOf(2, 4)), true)
        assertEquals(checkIntervalOveralps(listOf(1, 3), listOf(4, 5)), false)
        assertEquals(checkIntervalOveralps(listOf(4, 5), listOf(1, 3)), false)
        assertEquals(checkIntervalOveralps(listOf(2, 4), listOf(1, 2)), true)
    }

    @Test
    fun testMergeOverlappingIntervals() {
        assertEquals(
            mergeOverlappingIntervals(listOf(listOf(1, 3), listOf(2, 4), listOf(5, 6))),
            listOf(listOf(1, 4), listOf(5, 6))
        )
        assertEquals(
            mergeOverlappingIntervals(listOf()),
            listOf()
        )
    }

    @Test
    fun testFirstDuplicateValue() {
        assertEquals(firstDuplicateValue(mutableListOf(2, 1, 5, 2, 3, 3, 4)), 2)
    }

    @Test
    fun testLinkedListPalindrome() {
        assertEquals(linkedListPalindrome(linkedListOf(2)), true)
        assertEquals(linkedListPalindrome(linkedListOf(2, 3, 2)), true)
        assertEquals(linkedListPalindrome(linkedListOf(2, 2)), true)
        assertEquals(linkedListPalindrome(linkedListOf(2, 4)), false)
        assertEquals(linkedListPalindrome(linkedListOf(2, 3, 4)), false)
    }

}