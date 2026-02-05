class Solution {
    // Time: O(n^2)
    // Space: O(1)
    fun twoSum1(nums: IntArray, target: Int): IntArray {
        val count = nums.size
        var index1 = -1
        var index2 = -1

        for (index1 in 0..count - 2) {
            for (index2 in index1 + 1..count - 1) {
                if (nums[index1] + nums[index2] == target) {
                    return intArrayOf(index1, index2)
                }
            }
        }

        return intArrayOf()
    }

    // Time: O(n)
    // Space: O(n)
    fun twoSum2(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for (index in 0..nums.size - 1) {
            val complement = target - nums[index]
            if (map.containsKey(complement)) {
                return intArrayOf(map.get(complement)!!, index)
            }
            map.put(nums[index], index)
        }

        return intArrayOf()
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        Pair(intArrayOf(2, 7, 11, 15), 9),
        Pair(intArrayOf(3, 2, 4), 6),
        Pair(intArrayOf(3, 3), 6)
    )

    for ((nums, target) in testCases) {
        val result = solution.twoSum2(nums, target)
        println("Input: [${nums.joinToString()}]\nTarget: $target")
        println("-------------")
        println("Output: ${result.joinToString()}")
        println("----------------------------------")
        println("----------------------------------")
    }
}

