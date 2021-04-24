package students

class StudentService(private val dao: StudentDao) {
    fun findAll(): List<Student> = dao.findAll()

    fun create(name: String, facultyId: Int):Student = dao.create(name, facultyId)
}