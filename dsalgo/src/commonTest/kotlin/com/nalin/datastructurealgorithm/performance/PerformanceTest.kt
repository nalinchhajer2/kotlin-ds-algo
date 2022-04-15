package com.nalin.datastructurealgorithm.performance

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PerformanceTest {
    val TEST_SIZE = 100000

    @Test
    fun array_sequence_break_check() {
        val array = arrayOfNulls<Int>(TEST_SIZE) // 0 MS
        for (i in 0 until TEST_SIZE) { // 4 ms
            array[i] = i
        }

        var sequence: Int? = null // 1 ms
        for (i in array.indices) {
            if (array[i] == i) {
                sequence = i
            } else {
                break
            }
        }
        assertEquals(sequence, TEST_SIZE - 1)
        assertTrue { array.size == TEST_SIZE }
    }

    @Test
    fun set_performance() {
        val set = mutableSetOf<Int>()
        for (i in 0 until TEST_SIZE) { // 12 ms
            set.add(i)
        }

        var sequence: Int? = null // 21 ms
        for (i in 0 until TEST_SIZE) {
            if (set.contains(i)) {
                sequence = i
            } else {
                break
            }
        }

        assertEquals(sequence, TEST_SIZE - 1)
        assertTrue { set.size == TEST_SIZE }
    }

    @Test
    fun map_performance() {
        val map = hashMapOf<Int, Int>()
        for (i in 0 until TEST_SIZE) { // 11 ms
            map.put(i, 1)
        }

        var sequence: Int? = null // 16 ms
        for (i in 0 until TEST_SIZE) {
            if (map.get(i) == 1) {
                sequence = i
            } else {
                break
            }
        }

        assertEquals(sequence, TEST_SIZE - 1)
        assertTrue { map.size == TEST_SIZE }
    }
}