fun <T> stackOf(): Stack<T> = Stack()
fun <T> queueOf(): Queue<T> = Queue()

fun main(){
    val stack = stackOf<Int>()

    println("Stack:")
    for(i in 1..5){
        stack.push(i)
    }
    while (!stack.isEmpty()){
        println(stack.pop())
    }

    val queue = queueOf<String>()
    println("\nQueue:")
    queue.enQueue("One")
    queue.enQueue("Two")
    queue.enQueue("Three")

    while (!queue.isEmpty()){
        println(queue.deQueue())
    }



}