class Solution {
    // Time: O(n^m)
    // Space: O(1)
    fun recoverOrder1(order: IntArray, friends: IntArray): IntArray {
        val result = IntArray(friends.size) { -1 }
        var index = 0

        for (id in order) {
            for (friend in friends) {
                if (id == friend) {
                    result[index] = id
                    index += 1
                    break
                }
            }
        }

        return result
    }

    // Time: O(n^log(m))
    // Space: O(1)
    fun recoverOrder2(order: IntArray, friends: IntArray): IntArray {
        val result = IntArray(friends.size) { -1 }
        var index = 0

        for (id in order) {
            val friendIndex = friends.binarySearch(id)

            if (friendIndex >= 0) {
                result[index] = id
                index += 1
            }
        }

        return result
    }

    // Time: O(n)
    // Space: O(m)
    fun recoverOrder3(order: IntArray, friends: IntArray): IntArray {
        val friendSet = friends.toSet()

        val result = IntArray(friends.size) { -1 }
        var index = 0


        for (id in order) {
            if (friendSet.contains(id)) {
                result[index] = id
                index += 1
            }
        }

        return result
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        Pair(intArrayOf(3, 1, 2, 5, 4), intArrayOf(1, 3, 4)),
        Pair(intArrayOf(1, 4, 5, 3, 2), intArrayOf(2, 5)),
    )

    for ((order, friends) in testCases) {
        val result = solution.recoverOrder2(order, friends)
        println("Input:\norder = [${order.joinToString()}]\nfriends: [${friends.joinToString()}]")
        println("-------------")
        println("Output: ${result.joinToString()}")
        println("----------------------------------")
        println("----------------------------------")
    }
}

