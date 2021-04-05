interface CircleDAO {
	fun getCircleById(id: Int): Circle?
	fun getAllCircles(): List<Circle>
}