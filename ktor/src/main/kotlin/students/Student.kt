package students

import kotlinx.serialization.Serializable

@Serializable
data class Student(val id: Int, val name: String, val facultyId: Int)
