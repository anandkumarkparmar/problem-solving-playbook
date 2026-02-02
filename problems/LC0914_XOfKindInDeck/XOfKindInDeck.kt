class Solution {
    // Time: O(n log(n))
    // Space: O(n)
    fun hasGroupsSizeX(deck: IntArray): Boolean {
        val map = HashMap<Int, Int>()

        for (card in deck) {
            map[card] = (map[card] ?: 0) + 1
        }

        val check = true
        var countValues = map.values.distinct()
        val hcf = gcdOfList(countValues)

        if (hcf < 2) {
            return false
        } else {
            return true
        }
    }

    // Time: O(log(min(n1, n2)))
    fun gcd(n1: Int, n2: Int): Int {
        if (n2 == 0) {
            return n1
        }
        return gcd(n2, n1 % n2)
    }

    fun gcdOfList(numbers: List<Int>): Int {
        if (numbers.isEmpty()) {
            return 0
        }
        return numbers.reduce { acc, next -> gcd(acc, next) }
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        intArrayOf(1), // false
        intArrayOf(1, 2, 3, 4), // false
        intArrayOf(1, 2, 3, 4, 4, 3, 2, 1), // true
        intArrayOf(1, 1, 1, 2, 2, 2, 3, 3), // false
        intArrayOf(1, 1, 2, 2, 2, 2), // true
        intArrayOf(1, 1, 1, 1, 2, 2, 2, 2, 2, 2), // true
        intArrayOf(1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3), // true
    )

    for (testCase in testCases) {
        println("Input: ${testCase.joinToString()}")
        println("-------------")
        val result = solution.hasGroupsSizeX(testCase)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
