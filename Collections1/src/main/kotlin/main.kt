fun main(){
    val stack = stackOf<Int>()
    println("Stack:")
    for(i in 1..5){
        stack.push(i)
    }
    while (!stack.isEmpty()){
        println(stack.pop())
    }
    println(stack.pop())
    val queue = queueOf<String>()
    println("\nQueue:")
    queue.enqueue("On22e")
    queue.enqueue("Tw33o")
    queue.enqueue("Thr22ee")
    while (!queue.isEmpty()){
        println(queue.dequeue())
    }
    println(queue.dequeue())
}