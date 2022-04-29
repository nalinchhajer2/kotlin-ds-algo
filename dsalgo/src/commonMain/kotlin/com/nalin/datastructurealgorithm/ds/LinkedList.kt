package com.nalin.datastructurealgorithm.ds

class LinkedListNode<T>(var value: T) {
    var nextNode: LinkedListNode<T>? = null
}

fun <T> linkedListOf(vararg input: T): LinkedListNode<T>? {
    var headNode: LinkedListNode<T>? = null
    var lastNode: LinkedListNode<T>? = null
    input.forEach { value ->
        if (lastNode == null) {
            headNode = LinkedListNode(value)
            lastNode = headNode
        } else {
            lastNode?.nextNode = LinkedListNode(value)
            lastNode = lastNode?.nextNode
        }
    }
    return headNode
}