class Solution {
    // Time: O(?)
    // Space: O(?)
    fun clearDigits(s: String): String {
        val stack = ArrayDeque<Char>()
        val len = s.length

        for (i in 0 until len) {
            if (s[i].isDigit()) {
                stack.removeLastOrNull()
            } else {
                stack.addLast(s[i])
            }
        }

        return stack.joinToString("")
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        "abc",
        "cb34",
        "34",
        "a23asdasda1a123"
    )

    for (testCase in testCases) {
        println("Input: $testCase")
        println("-------------")
        val result = solution.clearDigits(testCase)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
