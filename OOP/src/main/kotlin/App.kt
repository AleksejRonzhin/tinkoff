fun main()
{
    val arthur = Hero("Arthur", damage = 55)
    val dragon = Enemy("Red Dragon","Dragons", HP = 100)
    val cleo = Ally("Cleo", 80, 20)

    val units = listOf(arthur,dragon,cleo)

    units.forEach()
    {
        it.sayHello()
    }

    dragon.hit(cleo)
    dragon.callFriends()

    arthur.hit(dragon)
    arthur.hit(dragon)
    arthur.hit(cleo)

    cleo.hill(arthur)

}