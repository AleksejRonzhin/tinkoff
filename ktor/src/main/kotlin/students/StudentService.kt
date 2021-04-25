package students

class StudentService(private val dao: StudentDao) {

    fun findAll(): List<Student> = dao.findAll()

    fun findById(id: Int):Student = dao.findById(id)

    fun findByFacultyId(id: Int):List<Student> = dao.findByFacultyId(id)

    fun moveToFaculty(id: Int, facultyId: Int) = dao.moveToFaculty(id, facultyId)

    fun create(name: String, facultyId: Int):Student = dao.create(name, facultyId)

    fun update(id: Int, name: String, facultyId: Int) = dao.update(id, name, facultyId)

    fun delete(id: Int) = dao.delete(id)
}