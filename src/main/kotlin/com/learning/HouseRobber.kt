package com.learning;

public class HouseRobber {

    fun rob(nums: IntArray): Int {
        val N = nums.size

        if (N == 1) return nums[0]
        if (N == 1) return maxOf(nums[0], nums[1])

        val dp = IntArray(N) {0}
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])

        var it = 2
        while (it < N) {
            dp[it] = maxOf(nums[it] + dp[it - 2], dp[it - 1])
            it++
        }

        return dp[N - 1];
    }

}

fun main() {
    val obj = HouseRobber()
    println( obj.rob(intArrayOf(1,2,3,1)) )
    println( obj.rob(intArrayOf(2,7,9,3,1)) )
}


