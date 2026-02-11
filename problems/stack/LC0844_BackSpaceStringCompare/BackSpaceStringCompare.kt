class Solution {
    // Time: O(n+m)
    // Space: O(1)
    fun backspaceCompare(s: String, t: String): Boolean {
        var i = s.length - 1
        var j = t.length - 1
        var count = 0

        while (i > -1 && j > -1) {
            count = 0
            while (i > -1 && (s[i] == '#' || count > 0)) {
                if (s[i] == '#') {
                    count += 1
                } else {
                    count -= 1

                }
                i -= 1
            }

            count = 0
            while (j > -1 && (t[j] == '#' || count > 0)) {
                if (t[j] == '#') {
                    count += 1
                } else {
                    count -= 1

                }
                j -= 1
            }

            if (i < 0 && j < 0) {
                return true
            } else if (i >= 0 && j >= 0) {
                if (s[i] == t[j]) {
                    i -= 1
                    j -= 1
                } else {
                    return false
                }
            } else {
                break
            }
        }


        return if (i > -1) {
            count = 0
            while (i > -1 && (s[i] == '#' || count > 0)) {
                if (s[i] == '#') {
                    count += 1
                } else {
                    count -= 1

                }
                i -= 1
            }

            return i < 0
        } else if (j >= 0) {
            count = 0
            while (j > -1 && (t[j] == '#' || count > 0)) {
                if (t[j] == '#') {
                    count += 1
                } else {
                    count -= 1

                }
                j -= 1
            }

            return j < 0
        } else {
            return true
        }
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        Pair("ab#c", "ad#c"),
        Pair("a", "aa#a"),
        Pair("abxj##tw", "bxo#j##tw"),
    )

    for (testCase in testCases) {
        println("Input: $testCase")
        println("-------------")
        val result = solution.backspaceCompare(testCase.first, testCase.second)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
