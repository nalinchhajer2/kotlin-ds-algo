package com.nalin.datastructurealgorithm.problems

import com.nalin.datastructurealgorithm.ds.LinkedListNode
import kotlin.math.max
import kotlin.math.min

fun mergeOverlappingIntervals(intervals: List<List<Int>>): List<List<Int>> {
    val sortedInterval = intervals.sortedBy {
        it[0]
    }

    val result = mutableListOf<MutableList<Int>>()
    for (item in sortedInterval) {
        if (result.size != 0 && checkIntervalOveralps(result.last(), item)) {
            result.last()[0] = min(item[0], result.last()[0])
            result.last()[1] = max(item[1], result.last()[1])
        } else {
            result.add(mutableListOf(item[0], item[1]))
        }
    }

    return result
}

fun checkIntervalOveralps(item1: List<Int>, item2: List<Int>): Boolean {
    // item1 left is not in item2 right
    // item1 right is not in item2 left
    return !((item1[0] < item2[0] && item1[1] < item2[0])
            || (item1[0] > item2[0] && item1[0] > item2[1]))
}

fun firstDuplicateValue(array: MutableList<Int>): Int {
    val map = hashMapOf<Int, Int>()
    for (item in array) {
        map.put(item, (map.get(item) ?: 0) + 1)
        if (map.get(item)!! > 1) {
            return item
        }
    }
    return -1
}

fun linkedListPalindrome(linkedList: LinkedListNode<Int>?): Boolean {
    fun _traverse(
        head: LinkedListNode<Int>,
        tail: LinkedListNode<Int>
    ): Pair<LinkedListNode<Int>?, Boolean> {
        var result = true
        var newHead: LinkedListNode<Int>? = head
        if (tail.nextNode !== null) {
            val (resHead, newResult) = _traverse(head, tail.nextNode!!)
            newHead = resHead
            result = newResult
        }
        return Pair(newHead?.nextNode, result && newHead?.value == tail.value)
    }

    return _traverse(linkedList!!, linkedList!!).second
}
