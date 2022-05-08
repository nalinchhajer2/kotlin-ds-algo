package com.nalin.datastructurealgorithm.ds

import kotlin.test.Test
import kotlin.test.assertEquals

class DataStructureTest {
    var testSize = 10000

    @Test
    fun testLinkedList() {
        val range = (1..testSize).toList().toTypedArray()
        val linkedList = linkedListOf<Int>(*range)
        var itratorNode = linkedList!!
        val result = arrayListOf<Int>()
        while (itratorNode.nextNode !== null) {
            result.add(itratorNode.value ?: 0)
            itratorNode = itratorNode.nextNode!!
        }
        result.add(itratorNode.value ?: 0)
        assertEquals(result, arrayListOf<Int>(*range))
    }

    @Test
    fun heapTest() {
        val heap = Heap<Int>(false)
        for (x in 0 until testSize) {
            heap.push(x)
        }
        assertEquals(heap.array.size, testSize)
        var isValid = true
        var expectedValue = testSize
        for (x in testSize - 1 downTo 0) {
            expectedValue--
            isValid = isValid && (expectedValue == heap.pop())
        }
        assertEquals(isValid, true)
        assertEquals(heap.array.size, 0)
    }

    @Test
    fun indexedPriorityQueueTest() {
        val ipq = IndexedPriorityQueue<Char>(false)
        for (x in 0 until testSize) {
            ipq.push('a' + x, x)
        }
        var isValid = true
        var expectedValue = 'a' + testSize
        for (x in testSize - 1 downTo 0) {
            expectedValue--
            isValid = isValid && (expectedValue == ipq.pop())
        }
        assertEquals(isValid, true)
    }

    @Test
    fun removeFromHeap() {
        val ipq = IndexedPriorityQueue<Char>(false)
        ipq.push('a', 3)
        ipq.push('b', 4)
        ipq.push('c', 5)
        ipq.push('d', 5)
        ipq.push('e', 100)
        ipq.remove('b')
        ipq.remove('c')
        ipq.remove('d')
        assertEquals(ipq.peek(), 'e')
        ipq.changePriority('e', 2)
        assertEquals(ipq.pop(), 'a')
    }
}