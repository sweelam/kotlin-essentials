package com.learning.review

import java.util.Arrays
import kotlin.math.min

class ArraySums {

    // O(N)
    fun findAllPairsIndexes(arr: IntArray, target: Int): MutableList<IntArray> {
        val result = mutableListOf<IntArray>()

        val map = mutableMapOf<Int, Int>()
        for ((idx, number) in arr.withIndex()) {
            if (target >= number) {
                val rem = target - number

                if (!map.contains(rem)) {
                    map.put(number, idx)
                } else {
                    result.add(arrayOf(idx, map[rem]!!.toInt()).toIntArray())
                    map.put(number, map[rem]!!.toInt())
                }
            }
        }

        return result
    }

    // O(NLogN)
    fun findAllPairsIndexesV2(arr: IntArray, target: Int): MutableList<IntArray> {
        val result = mutableListOf<IntArray>()

        for ((idx, number) in arr.withIndex()) {
            if (target >= number) {
                val rem = target - number

                val idxFound = Arrays.binarySearch(arr, 0, arr.size - 1, rem)
                if (idxFound >= 0)
                    result.add(arrayOf(idx, idxFound).toIntArray())
            }
        }

        return result
    }

    fun findAllPairs(arr: IntArray, target: Int): MutableList<IntArray> {
        val result = mutableListOf<IntArray>()

        val map = mutableSetOf<Int>()
        for (number in arr) {
            if (target >= number) {
                val rem = target - number

                if (!map.contains(rem)) {
                    map.add(number)
                } else {
                    result.add(arrayOf(number, rem).toIntArray())
                }
            }
        }

        return result
    }
}


fun main() {

    val arrSum = ArraySums()
    val TCs = mutableListOf<IntArray>()
    // target 7 , 8 , 9
    TCs.add(arrayOf(6, 1, 4, 5, 2, 3, 7, 0).toIntArray())
    TCs.add(arrayOf(4, 2, 6, 7, 1, 4, 3, 5).toIntArray())
    TCs.add(arrayOf(6, 1, 4, 5, 2, 3, 7, 0).toIntArray())

    println("Using HashSet ")
    arrSum.findAllPairsIndexes(TCs[0], 7).forEach { it -> print("(${it[0]}, ${it[1]}) \t") }
    println()

    println("Using BST ")
    arrSum.findAllPairsIndexesV2(TCs[0], 7).forEach { it -> print("(${it[0]}, ${it[1]}) \t") }
}