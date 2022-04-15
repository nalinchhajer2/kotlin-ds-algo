package com.nalin.datastructurealgorithm.ds

import kotlin.test.Test
import kotlin.test.assertEquals

class DataStructureTest {

    @Test
    fun testLinkedList() {
        val linkedList = linkedListOf<Int>(1,2)
        var itratorNode = linkedList
        val result = arrayListOf<Int>()
        while(itratorNode.nextNode !== null) {
            result.add(itratorNode.value ?: 0)
            itratorNode = itratorNode.nextNode!!
        }
        //assertEquals(result, arrayListOf<Int>(1,2))
    }
}