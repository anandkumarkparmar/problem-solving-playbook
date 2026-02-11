class Solution {
    // Time: O(n) - n = s.length
    // Space: O(3n)
    fun removeOuterParentheses1(s: String): String {
        val stack = ArrayDeque<Char>()

        var ans = ""
        var startIndex = -1
        for (i in s.indices) {
            if (s[i] == '(') {
                if (startIndex == -1) {
                    startIndex = i
                }
                stack.addLast(s[i])
            } else {
                stack.removeLast()
                if (stack.isEmpty()) {
                    if (startIndex < i - 1) {
                        ans += s.subSequence(startIndex + 1, i)
                    }
                    startIndex = -1
                }
            }
        }

        return ans
    }

    // Time: O(n) - n = s.length
    // Space: O(n)
    fun removeOuterParentheses2(s: String): String {
        var counter = 0
        var ans = ""

        for (i in s.indices) {
            if (s[i] == '(') {
                if (counter > 0) {
                    ans += s[i]
                }
                counter += 1
            } else {
                counter -= 1
                if (counter > 0) {
                    ans += s[i]
                }
            }
        }

        return ans
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        "(()())(())",
        "(()())(())(()(()))"
    )

    for (testCase in testCases) {
        println("Input: $testCase")
        println("-------------")
        val result = solution.removeOuterParentheses2(testCase)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
