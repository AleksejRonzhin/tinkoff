package faculties

class FacultyService(private val dao: FacultyDao) {

    fun findAll():List<Faculty> = dao.findAll()

    fun findById(id: Int): Faculty = dao.findById(id)

    fun create(name: String): Faculty = dao.create(name)

    fun update(id: Int, name: String) = dao.update(id, name)

    fun delete(id: Int) = dao.delete(id)

}