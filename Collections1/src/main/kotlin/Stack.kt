class Stack<T> {

    private val list = mutableListOf<T>()

    fun isEmpty(): Boolean = this.list.isEmpty()

    fun push(element: T){
        this.list.add(element)
    }

    fun pop(): T? = this.list.removeLastOrNull()

}