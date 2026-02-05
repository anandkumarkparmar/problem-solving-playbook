class Solution {
    // Time: O(n)
    // Space: O(n)
    fun smallestAbsent(nums: IntArray): Int {
        val set = HashSet<Int>()
        val size = nums.size
        var sum = 0

        for (num in nums) {
            set.add(num)
            sum += num
        }

        val average = Math.ceil(sum * 1.0 / size).toInt()

        var ans = if (average <= 0) {
            1
        } else {
            if (sum % size == 0) average + 1 else average
        }

        while(true) {
            if (set.contains(ans)) {
                ans += 1
                continue
            } else {
                break
            }
        }

        return ans
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        intArrayOf(3, 5),
        intArrayOf(-1, 1, 2),
        intArrayOf(4, -1),
        intArrayOf(-4, -3, -2, -1, 1, 2, 4, 3),
        intArrayOf(-4),
    )

    for (testCase in testCases) {
        println("Input: ${testCase.joinToString()}")
        println("-------------")
        val result = solution.smallestAbsent(testCase)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
