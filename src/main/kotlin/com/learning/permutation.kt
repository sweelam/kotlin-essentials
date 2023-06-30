import java.util.*


class Solve {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        return listOf();
    }

    fun permute(nums: IntArray): List<List<Int?>>? {
        val output: MutableList<List<Int?>> = ArrayList()
        val numList = ArrayList<Int?>()
        for (nu in nums) numList.add(nu)
        val n = nums.size
        backtrack(n, numList, output, 0)
        return output
    }

    fun backtrack(
        n: Int,
        numList: List<Int?>?,
        output: MutableList<List<Int?>>,
        first: Int
    ) {
        if (first == n) {
            output.add(ArrayList(numList))
        }
        for (i in first until n) {
            Collections.swap(numList, first, i)
            backtrack(n, numList, output, first + 1)
            Collections.swap(numList, first, i)
        }
    }


    fun perm(numbers: IntArray) : List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        helper(res, mutableListOf(), numbers, BooleanArray(numbers.size) {false});

        return res;
    }

    fun helper (res : MutableList<List<Int>>,
                perm : MutableList<Int>,
                numbers: IntArray,
                used : BooleanArray) {

        if (perm.size == numbers.size) {
            res.add(ArrayList(perm))
            return
        }

        for ((idx, num) in numbers.withIndex()) {
            if (!used[idx]) {
                used[idx] = true
                perm.add(num)
                helper(res, perm, numbers, used)
                perm.removeAt(perm.size - 1)
                used[idx] = false
            }
        }

    }
}

/**
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
fun main() {
    val solve = Solve()
    solve.perm(intArrayOf(1,2,3))
}