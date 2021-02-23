class Ally(name: String, override var health: Int = 100,
           override var damage: Int = 20): Unit(name)
{
    override fun sayHello()
    {
        println("Hello, my name is $name. I help Hero")
    }

    override fun hit(target: Unit) {
        if(target is Enemy)
        {
            println("${this.name} hit ${target.name}(${target.health}-${this.damage})")
            target.health -= this.damage
            if(target.health < 1){
                println("${this.name} kill ${target.name}!")
                target.health = 100
            }
        }
        else
        {
            println("${this.name}: I will not hit ${target.name}. I can hit only enemy")
        }

    }

    fun hill(target: Unit){
        if(target !is Enemy)
        {
            println("${this.name} hill ${target.name}(${target.health}+20)")
            target.health += 20
            if(target.health>100)
            {
                target.health=100
            }
        }
        else
        {
            println("${this.name}: I will not hill ${target.name}. He is Enemy")
        }
    }

}