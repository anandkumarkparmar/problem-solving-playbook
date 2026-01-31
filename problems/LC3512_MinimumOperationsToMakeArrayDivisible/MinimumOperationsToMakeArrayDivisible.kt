
class Solution {

    // Time: O(n)
    // Space: O(1)
    fun minOperations(nums: IntArray, k: Int): Int {
        return nums.sum() % k
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        Pair(intArrayOf(3,9,7), 5),
        Pair(intArrayOf(4,1,3), 4),
        Pair(intArrayOf(3, 2), 6)
    )

    for ((nums, k) in testCases) {
        val result = solution.minOperations(nums, k)
        println("Input: [${nums.joinToString()}]\nk: $k")
        println("-------------")
        println("Output: ${result}")
        println("----------------------------------")
        println("----------------------------------")
    }
}