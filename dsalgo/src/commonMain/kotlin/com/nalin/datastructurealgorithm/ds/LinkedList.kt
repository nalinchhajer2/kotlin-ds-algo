package com.nalin.datastructurealgorithm.ds

class LinkedListNode<T> {
    var value: T? = null
    var nextNode: LinkedListNode<T>? = null
}

fun <T> linkedListOf(vararg input: T) : LinkedListNode<T> {
    val headNode = LinkedListNode<T>()
    var lastNode = headNode
    input.forEach { value ->
        lastNode.value = value
        lastNode.nextNode = LinkedListNode()
        lastNode = lastNode.nextNode!!
    }
    return headNode
}