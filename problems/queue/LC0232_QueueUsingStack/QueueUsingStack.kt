class MyQueue() {

    val stack = ArrayDeque<Int>()

    fun push(x: Int) {
        if (empty()) {
            stack.addLast(x)
        } else {
            val lastElement = pop()
            push(x)
            stack.addLast(lastElement)
        }
    }

    fun pop(): Int {
        return stack.removeLast()
    }

    fun peek(): Int {
        return stack.last()
    }

    fun empty(): Boolean {
        return stack.isEmpty()
    }
}

fun main() {
    val queue = MyQueue()

    println("-------------")
    println("push: ${queue.push(1)}")
    println("push: ${queue.push(2)}")
    println("peek: ${queue.peek()}")
    println("pop: ${queue.pop()}")
    println("peek: ${queue.peek()}")
    println("empty: ${queue.empty()}")
    println("----------------------------------")
    println("----------------------------------")
}
