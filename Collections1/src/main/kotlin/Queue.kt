class Queue<T> {

    private val list = mutableListOf<T>()

    fun isEmpty(): Boolean = this.list.isEmpty()

    fun enqueue(element: T){
        this.list.add(element)
    }

    fun dequeue(): T? = this.list.removeFirstOrNull()
}