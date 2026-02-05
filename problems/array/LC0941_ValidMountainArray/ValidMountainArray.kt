class Solution {
    // Time: O(n)
    // Space: O(1)
    fun validMountainArray(arr: IntArray): Boolean {
        var directionUp = true
        var stepUpCount = 0
        var stepDownCount = 0

        for (i in 1 until arr.size) {
            if (directionUp) {
                if (arr[i - 1] < arr[i]) {
                    stepUpCount += 1
                } else if (arr[i-1] == arr[i]) {
                    return false
                } else {
                    stepDownCount += 1
                    directionUp = false
                }
            } else {
                if (arr[i-1] > arr [i]) {
                    stepDownCount += 1
                } else {
                    return false
                }
            }
        }

        if (stepUpCount > 0 && stepDownCount > 0) {
            return true
        } else {
            return false
        }
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        intArrayOf(2, 1),
        intArrayOf(3, 5, 5),
        intArrayOf(0, 3, 2, 1)
    )

    for (testCase in testCases) {
        println("Input: ${testCase.joinToString()}")
        println("-------------")
        val result = solution.validMountainArray(testCase)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
