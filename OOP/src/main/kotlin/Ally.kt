class Ally(name: String, override var HP: Int = 100,
            override var damage: Int = 20): Unit(name)
{
    override fun sayHello()
    {
        println("Hello, my name is $name. I help Hero")
    }

    override fun hit(target: Unit) {
        println("${this.name} hit ${target.name}(${target.HP}-${this.damage})")
        target.HP -= this.damage
        if(target.HP < 1){
            println("${this.name} kill ${target.name}!")
            target.HP = 100
        }
    }

    fun hill(target: Unit){
        println("${this.name} hill ${target.name}(${target.HP}+20)")
        target.HP += 20
    }

}