package students

class StudentService(private val dao: StudentDao) {
    fun findAll(): List<Student> = dao.findAll()
}