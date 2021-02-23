class Hero(name: String, override var health: Int = 100,
           override var damage: Int = 20):Unit(name)
{
    private var lvl = 1

    private fun lvlUp() {
        this.lvl++
    }

    override fun sayHello()
    {
        println("Hello, my name is $name. I am Hero $lvl lvl")
    }

    override fun hit(target: Unit)
    {
        if(target is Enemy) {
            println("${this.name} hit ${target.name}(${target.health}-${this.damage})")
            target.health -= this.damage
            if (target.health < 1) {
                this.lvlUp()
                println("${this.name} kill ${target.name} and get lvl-up! New lvl is ${this.lvl}")
                target.health = 100
            }
        }
        else
        {
            println("${this.name}: I will not hit ${target.name}. I can hit only enemy")
        }
    }


}