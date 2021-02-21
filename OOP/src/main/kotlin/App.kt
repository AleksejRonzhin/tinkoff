fun main()
{
    val pudge = Hero("Pudge",200, 50)
    pudge.sayHello()
    pudge.getInfo()
    val dragon = Enemy("Dragon","Dragons", damage = 300)
    dragon.getInfo()
    dragon.sayHello()
    pudge.hit(dragon)
    dragon.hit(pudge)
    dragon.callFriends()
    val wd = Ally("Witch Doctor")
    wd.hill(pudge)
    pudge.getInfo()
    wd.sayHello()
    wd.getInfo()

}