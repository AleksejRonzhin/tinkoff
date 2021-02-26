fun <T> stackOf(): Stack<T> = Stack()
fun <T> queueOf(): Queue<T> = Queue()

fun main(){

    val stack = stackOf<Int>()

    stack.push(1)
    stack.push(2)
    stack.push(3)

    println(stack.pop())
    println(stack.pop())
    println(stack.pop())

    val queue = queueOf<String>()

    queue.enQueue("One")
    queue.enQueue("Two")
    queue.enQueue("Three")

    println(queue.deQueue())
    println(queue.deQueue())
    println(queue.deQueue())



}