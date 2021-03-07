class Stack<T> {

    private val list = mutableListOf<T>()

    fun isEmpty(): Boolean = this.list.isEmpty()

    fun push(element: T){
        this.list.add(element)
    }

    fun pop(): T? = this.list.removeLastOrNull()
}

fun <T> stackOf(vararg elements: T): Stack<T> {
    val stack = Stack<T>()
    elements.forEach {
        stack.push(it)
    }
    return stack
}