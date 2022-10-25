package com.bnitech.kotlin.leetcode

import java.util.*

data class LRUCache(val capacity: Int) {
    private val linkedList = LinkedList<Pair<Int, Int>>()

    fun get(key: Int): Int {
        for (pair: Pair<Int, Int> in linkedList) {
            if (pair.first == key) {
                linkedList.remove(pair)
                linkedList.addFirst(pair)
                return pair.second
            }
        }

        return -1;
    }

    fun put(key: Int, value: Int) {
        val result = get(key)
        if (result != -1) {
            for ((index, pair) in linkedList.withIndex()) {
                if (pair.first == key) {
                    linkedList[index] = Pair(key, value)
                    return
                }
            }
        }

        if (linkedList.size >= capacity) {
            linkedList.removeLast();
        }

        linkedList.addFirst(Pair(key, value))
    }

    fun printList() {
        println(linkedList)
    }
}
