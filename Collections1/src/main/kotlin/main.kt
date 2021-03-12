fun main(){
    val stack = stackOf<Int>(6, 8, 0, 5)
    stack.push(3)
    println("Stack:")
    while (!stack.isEmpty()){
        println(stack.pop())
    }
    println(stack.pop())
    val queue = queueOf<String>("A","BB","CCC")
    queue.enqueue("One")
    println("\nQueue:")
    while (!queue.isEmpty()){
        println(queue.dequeue())
    }

}