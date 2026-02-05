class MyStack() {
    val queue = ArrayDeque<Int>()

    fun push(x: Int) {
        var initSize = queue.size
        queue.addLast(x)
        while (initSize > 0) {
            queue.addLast(queue.removeFirst())
            initSize -= 1
        }
    }

    fun pop(): Int {
        return queue.removeFirst()
    }

    fun top(): Int {
        return queue.first()
    }

    fun empty(): Boolean {
        return queue.size == 0
    }
}

fun main() {
    val stack = MyStack()

    println("-------------")
    println("push: ${stack.push(1)}")
    println("push: ${stack.push(2)}")
    println("top: ${stack.top()}")
    println("pop: ${stack.pop()}")
    println("top: ${stack.top()}")
    println("empty: ${stack.empty()}")
    println("----------------------------------")
    println("----------------------------------")
}
