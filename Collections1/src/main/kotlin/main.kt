fun main(){

    val stack = Stack()
    val queue = Queue()

    stack.push(5)
    stack.push(2)
    queue.enQueue(5)
    queue.enQueue(2)

    println(stack.pop())
    println(stack.pop())
    println(queue.deQueue())
    println(queue.deQueue())


}