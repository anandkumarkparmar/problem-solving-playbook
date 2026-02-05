class Solution {
    // Time: O(n*m)
    // Space: O(1)
    fun countStudents1(students: IntArray, sandwiches: IntArray): Int {
        var i = 0
        val studentsSize = students.size

        var j = 0
        val sandwichesSize = sandwiches.size

        while (j < sandwichesSize) {
            val startIndex = i
            var check = true
            while (check || startIndex != i) {
                check = false
                if (students[i] == sandwiches[j]) {
                    students[i] = -1
                    i = (i + 1) % studentsSize
                    j += 1
                    break
                } else {
                    i = (i + 1) % studentsSize
                }
            }

            if (startIndex == i) {
                break
            }
        }

        return students.count { it == 0 || it == 1 }
    }

    // Time: O(n)
    // Space: O(1)
    fun countStudents2(students: IntArray, sandwiches: IntArray): Int {
        var countOf0s = 0
        var countOf1s = 0

        for (s in students) {
            if (s == 0) {
                countOf0s += 1
            } else {
                countOf1s += 1
            }
        }

        for (s in sandwiches) {
            if (s == 0 && countOf0s == 0) {
                return countOf1s
            }

            if (s == 1 && countOf1s == 0) {
                return countOf0s
            }

            if (s == 0) {
                countOf0s -= 1
            } else {
                countOf1s -= 1
            }
        }

        return 0
    }
}

fun main() {
    val solution = Solution()

    val testCases = listOf(
        Pair(intArrayOf(1, 1, 0, 0), intArrayOf(0, 1, 0, 1)),
        Pair(intArrayOf(1, 1, 1, 0, 0, 1), intArrayOf(1, 0, 0, 0, 1, 1)),
    )

    for ((students, sandwiches) in testCases) {
        println("Input: student: ${students.joinToString()}, sandwiches: ${sandwiches.joinToString()}")
        println("-------------")
        val result = solution.countStudents2(students, sandwiches)
        println("Output: $result")
        println("----------------------------------")
        println("----------------------------------")
    }
}
