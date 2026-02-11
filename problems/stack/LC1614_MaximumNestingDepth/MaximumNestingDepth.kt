class Solution {
    // Time: O(n)
    // Space: O(1)
    fun maxDepth(s: String): Int {
        var counter = 0
        var maxValue = 0

        for (c in s) {
            if (c == '(') {
                counter += 1
            } else if (c == ')') {
                if (counter > maxValue) {
                    maxValue = counter
                }
                counter = counter - 1
            }
        }

        return maxValue
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        "(1+(2*3)+((8)/4))+1",
        "(1)+((2))+(((3)))",
        "()(())((()()))"
    )

    for (testCase in testCases) {
        println("Input: $testCase")
        println("-------------")
        val result = solution.maxDepth(testCase)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
