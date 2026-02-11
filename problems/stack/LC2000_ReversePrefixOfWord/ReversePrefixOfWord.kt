class Solution {
    // Time: O(n)
    // Space: O(n)
    fun reversePrefix(word: String, ch: Char): String {
        var ans = word
        for (i in word.indices) {
            if (word[i] == ch) {
                val prefix = word.substring(0, i+1).reversed()
                val sufix = if (i == word.length - 1) "" else word.substring(i+1)
                ans = prefix + sufix
                break
            }
        }

        return ans
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        Pair("abcdefd", 'd'),
        Pair("xyxzxe", 'z'),
        Pair("abcd", 'z'),
    )

    for (testCase in testCases) {
        println("Input: $testCase")
        println("-------------")
        val result = solution.reversePrefix(testCase.first, testCase.second)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
