abstract class Unit(val name: String)
{
    abstract var health:Int
    abstract var damage:Int

    open fun sayHello()
    {
        println("Hello, my name is $name")
    }

    fun getInfo()
    {
        println("Name: $name, HP: $health, damage: $damage")
    }

    abstract fun hit(target:Unit)

}