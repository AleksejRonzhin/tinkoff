class Queue<T> {

    private val list = mutableListOf<T>()

    fun isEmpty(): Boolean {
        return this.list.isEmpty()
    }

    fun enQueue(element: T){
        this.list.add(element)
    }

    fun deQueue(): T?{
        val temp: T?
        if(!this.isEmpty()) {
            temp = this.list[0]
            this.list.removeAt(0)
        }
        else temp = null
        return temp
    }
}