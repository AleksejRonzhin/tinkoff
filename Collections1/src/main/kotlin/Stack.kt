class Stack {

    private val list = mutableListOf<Any>()

    fun push(element: Any){
        this.list.add(element)
    }

    fun pop(): Any{
        val lastElement = this.list.lastIndex
        val temp = this.list[lastElement]
        this.list.removeAt(lastElement)
        return temp
    }
}