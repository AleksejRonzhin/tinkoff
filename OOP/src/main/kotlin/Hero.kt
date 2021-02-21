class Hero(name: String, override var HP: Int = 100,
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
        println("${this.name} hit ${target.name}(${target.HP}-${this.damage})")
        target.HP -= this.damage
        target.getInfo()
        if(target.HP < 1){
            this.lvlUp()
            println("${this.name} kill ${target.name} and get lvl-up! New lvl is ${this.lvl}")
            target.HP = 100
        }
    }


}