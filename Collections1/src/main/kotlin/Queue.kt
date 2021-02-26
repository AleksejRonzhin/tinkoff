class Queue {

    private val list = mutableListOf<Any>()

    fun enQueue(element: Any){
        this.list.add(element)
    }

    fun deQueue(): Any{
        val temp = this.list[0]
        this.list.removeAt(0)
        return temp
    }
}