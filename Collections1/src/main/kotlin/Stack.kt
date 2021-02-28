class Stack<T> {

    private val list = mutableListOf<T>()

    fun isEmpty(): Boolean {
        return this.list.isEmpty()
    }

    fun push(element: T){
        this.list.add(element)
    }

    fun pop(): T? {
        val temp: T?
        if(!this.isEmpty()){
            val lastElement = this.list.lastIndex
            temp = this.list[lastElement]
            this.list.removeAt(lastElement)
        }
        else temp = null
        return temp
    }

}