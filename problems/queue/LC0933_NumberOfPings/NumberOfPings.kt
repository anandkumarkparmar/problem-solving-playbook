class RecentCounter() {

    val queue = ArrayDeque<Int>()

    fun ping(t: Int): Int {
        queue.addLast(t)

        while (queue.first() < t - 3000) {
            queue.removeFirst()
        }

        return queue.size
    }

}

fun main() {
    val counter = RecentCounter()

    val testCases = listOf(
        1,
        100,
        3001,
        3002
    )

    for (testCase in testCases) {
        println("Input: $testCase")
        println("-------------")
        val result = counter.ping(testCase)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
