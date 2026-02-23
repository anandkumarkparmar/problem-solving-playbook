class Solution {
    // Time: O(n^2)
    // Space: O(n)
    fun finalPrices1(prices: IntArray): IntArray {
        val size = prices.size

        for (i in prices.indices) {
            val price = prices[i]
            inner@ for (j in (i + 1)..(size - 1)) {
                if (prices[j] <= price) {
                    val finalPrice = price - prices[j]
                    prices[i] = finalPrice
                    break@inner
                }
            }
        }

        return prices
    }

    // Time: O(n)
    // Space: O(n)
    fun finalPrices2(prices: IntArray): IntArray {
        val size = prices.size
        val stack = ArrayDeque<Int>()

        for (i in 0..size-1) {
            while (!stack.isEmpty() && prices[stack.last()] >= prices[i]) {
                prices[stack.removeLast()] -= prices[i]
            }
            stack.addLast(i)
        }

        return prices
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        intArrayOf(8, 4, 6, 2, 3),
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(10, 1, 1, 6),
        intArrayOf(10),
        intArrayOf(10, 1),
        intArrayOf(8,7,4,2,8,1,7,7,10,1)
    )

    for (testCase in testCases) {
        println("Input: ${testCase.joinToString()}")
        println("-------------")
        val result = solution.finalPrices2(testCase)
        println("Output: ${result.joinToString()}")
        println("----------------------------------")
        println("----------------------------------")
    }
}
