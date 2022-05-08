package com.nalin.datastructurealgorithm.problems

import com.nalin.datastructurealgorithm.ds.LinkedListNode
import kotlin.math.max
import kotlin.math.min

/**
 * Merge overlapping intervals. They are not likely to be in order
 */
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

/**
 * Check if a given linked list is palindrome or not
 */
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

/**
 * Find min area rectangle in 2D-plane
 */
fun minimumAreaRectangle(points: List<List<Int>>): Int {
    // Write your code here.
    return 0
}

fun findRectangleFromPoints(points: List<List<Int>>) {
    val mutablePoints = points.toMutableList()
    // Need in x, y plane only
    // square can also be consider as rect
    // 4 points in x, y plane will form triangle if
    // 2 points in x, 2 points in y are same
    // x1,y1 x1,y2 x2,y1 x2,y2 -> x1,x2,y1,y2
    // 1,5 2,5 1,3 2,3 -> 1,2,5,3

    // nlogn + n ^ 2 + n

    val mapX = mergePointsFromGivenDimension(mutablePoints, 0, 1) // 1,5 1,3
    val mapY = mergePointsFromGivenDimension(mutablePoints, 1, 0)

    for ((xIndex, yPoints) in mapX) {
        // 5, 3, 8, 9

    }
    // 5 -> 1 or 3 -> 1 and 3 in x contains 3

    // check if a point can be part of a rect
}

fun mergePointsFromGivenDimension(
    points: MutableList<List<Int>>,
    dimensionFrom: Int,
    dimensionTo: Int
): MutableMap<Int, MutableSet<Int>> {
    val dict: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
    for (point in points) {
        var list: MutableSet<Int>? = dict[point[dimensionFrom]]
        if (list == null) {
            list = mutableSetOf()
        }
        list.add(point[dimensionTo])
        dict[point[dimensionFrom]] = list
    }

    val dictIterator = dict.entries.iterator()
    while (dictIterator.hasNext()) {
        val (_, value) = dictIterator.next()
        if (value.size < 2) {
            dictIterator.remove()
        }
    }
    return dict
}


