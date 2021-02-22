class Enemy(name: String, var race:String, override var HP: Int = 200,
       override var damage: Int = 50): Unit(name)
{
    override fun sayHello()
    {
        println("Hello, my name is $name. I kill you in future")
    }

    override fun hit(target: Unit) {
        println("${this.name} hit ${target.name}(${target.HP}-${this.damage})")
        target.HP -= this.damage
        if(target.HP < 1){
            println("${this.name} kill ${target.name}! :(")
            target.HP = 100
        }
    }

    fun callFriends()
    {
        println("${this.name} shout: ${this.race}, I need help!")
    }
}