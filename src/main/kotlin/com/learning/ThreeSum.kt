package com.learning

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        for ((i, a) in nums.withIndex()) {
            if (i > 0 && nums[i - 1] == a) continue
            var lPtr = i + 1;
            var rPtr = nums.size - 1
            while (lPtr < rPtr) {
                val sum = a + nums[lPtr] + nums[rPtr]
                if (sum > 0) rPtr--
                if (sum < 0) lPtr++
                if (sum == 0) {
                    result.add(listOf(a, nums[lPtr], nums[rPtr]))
                    lPtr++
                    while (nums[lPtr] == nums[lPtr - 1] && lPtr < rPtr)
                        lPtr++
                }
            }
        }

        return result
    }
}

fun main() {
    val solution = Solution()
    println("Result is ${solution.threeSum(arrayOf(-1, 0, 1, 2, -1, -4).toIntArray())}")
    println("Result is ${solution.threeSum(arrayOf(0).toIntArray())}")
}
