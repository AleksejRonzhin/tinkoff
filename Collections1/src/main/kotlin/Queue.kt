class Queue<T> {

    private val list = mutableListOf<T>()

    fun enQueue(element: T){
        this.list.add(element)
    }

    fun deQueue(): T{
        val temp = this.list[0]
        this.list.removeAt(0)
        return temp
    }
}