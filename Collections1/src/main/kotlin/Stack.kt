class Stack<T> {

    private val list = mutableListOf<T>()

    fun push(element: T){
        this.list.add(element)
    }

    fun pop(): T{
        val lastElement = this.list.lastIndex
        val temp = this.list[lastElement]
        this.list.removeAt(lastElement)
        return temp
    }

}