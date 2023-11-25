package Models

import java.time.LocalDate

data class Student(var Id: Int, var Surname: String, var Name: String, var Middlename: String, var Gender: Char, var BirthDay: LocalDate)
