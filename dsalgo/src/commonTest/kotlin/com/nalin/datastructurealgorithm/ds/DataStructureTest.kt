package com.nalin.datastructurealgorithm.ds

import kotlin.test.Test
import kotlin.test.assertEquals

class DataStructureTest {

    @Test
    fun testLinkedList() {
        val range = (1..10000).toList().toTypedArray()
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
}