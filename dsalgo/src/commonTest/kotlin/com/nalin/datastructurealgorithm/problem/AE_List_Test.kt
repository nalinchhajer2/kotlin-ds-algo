package com.nalin.datastructurealgorithm.problem

import com.nalin.datastructurealgorithm.ds.Queue
import com.nalin.datastructurealgorithm.ds.linkedListOf
import com.nalin.datastructurealgorithm.problems.*
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

    @Test
    fun testQueue() {
        val queue = Queue<Char>()
        queue.enqueue('a')
        queue.enqueue('b')
        queue.enqueue('c')
        assertEquals(queue.dequeue(), 'a')
        assertEquals(queue.dequeue(), 'b')
        assertEquals(queue.dequeue(), 'c')
        assertEquals(queue.dequeue(), null)
    }

    @Test
    fun testFindRectangleFromPoints() {
        val lot = List(100000) { listOf(it, 2) }.toMutableList()
        lot.addAll(List(1) { listOf(it, 3) })
//        mergePointsFromGivenDimension(lot, 0, 1)
        assertEquals(
            mergePointsFromGivenDimension(lot, 0, 1),
            mutableMapOf(Pair(0, mutableSetOf(2, 3)))
        )
    }

}