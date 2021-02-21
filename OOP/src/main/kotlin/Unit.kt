abstract class Unit(val name: String)
{
    abstract var HP:Int
    abstract var damage:Int

    open fun sayHello()
    {
        println("Hello, my name is $name")
    }

    fun getInfo()
    {
        println("Name: $name, HP: $HP, damage: $damage")
    }

    abstract fun hit(target:Unit)

}