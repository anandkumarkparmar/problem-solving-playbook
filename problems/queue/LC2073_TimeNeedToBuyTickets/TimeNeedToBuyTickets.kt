class Solution {
    // Time: O(n)
    // Space: O(1)
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        val ticketsForK = tickets[k]
        var time = 0
        for (i in tickets.indices) {
            if (i <= k) {
                time += Math.min(ticketsForK, tickets[i])
            } else {
                time += Math.min(ticketsForK - 1, tickets[i])
            }
        }

        return time
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        Pair(intArrayOf(2, 3, 2), 2),
        Pair(intArrayOf(5, 1, 1, 1), 0)
    )

    for ((tickets, k) in testCases) {
        println("Input: tickets: ${tickets.joinToString()} k: $k")
        println("-------------")
        val result = solution.timeRequiredToBuy(tickets, k)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
