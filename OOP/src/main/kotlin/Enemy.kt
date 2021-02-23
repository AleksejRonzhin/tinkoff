class Enemy(name: String, var race:String, override var health: Int = 200,
            override var damage: Int = 50): Unit(name)
{
    override fun sayHello()
    {
        println("Hello, my name is $name. I kill you in future")
    }

    override fun hit(target: Unit) {
        println("${this.name} hit ${target.name}(${target.health}-${this.damage})")
        target.health -= this.damage
        if(target.health < 1){
            println("${this.name} kill ${target.name}! :(")
            target.health = 100
        }
    }

    fun callFriends()
    {
        println("${this.name} shout: ${this.race}, I need help!")
    }

    fun callFriends(race: String)
    {
        println("${this.name} shout: $race, I need help!")
    }

}