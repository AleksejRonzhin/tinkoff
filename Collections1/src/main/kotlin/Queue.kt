class Queue<T> {

    private val list = mutableListOf<T?>()
    private var firstIndex = 0

    fun isEmpty(): Boolean = this.list.lastIndex < firstIndex

    fun enqueue(element: T){
        this.list.add(element)
    }

    fun dequeue(): T? {
        return if (isEmpty()) null else {
            val temp = list[firstIndex]
            list[firstIndex++] = null
            temp
        }
    }
}

fun <T> queueOf(vararg elements: T): Queue<T> {
    val queue = Queue<T>()
    elements.forEach {
        queue.enqueue(it)
    }
    return queue
}