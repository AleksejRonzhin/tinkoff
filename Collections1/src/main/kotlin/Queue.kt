import java.util.LinkedList

class Queue<T> {
    private val list: LinkedList<T?> = LinkedList()

    fun isEmpty(): Boolean = this.list.isEmpty()

    fun enqueue(element: T) = this.list.add(element)

    fun dequeue(): T? = this.list.removeFirstOrNull()
}

fun <T> queueOf(vararg elements: T): Queue<T> {
    val queue = Queue<T>()
    elements.forEach {
        queue.enqueue(it)
    }
    return queue
}