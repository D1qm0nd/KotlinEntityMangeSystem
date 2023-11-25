package Models

import Exceptions.ValidationException
import Factory
import Validator
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class StudentFactory(validator: Validator<Student>) : Factory<Student>(validator) {
    override fun Create(): Student {
        return Student(0,"","","",' ', LocalDate.now());
    }

    override fun Create(params: List<String?>): Student {
        if (params.count() != 5) //mb crash -> params?.count()
            throw ValidationException("Not enough parameters");
//        val id = params[0]?.toIntOrNull()
        val surname = params[0]
        val name = params[1]
        val middlename = params[2]
        val gender = params[3]?.get(0)
        val date = LocalDate.parse(params[4]?.trimEnd(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        if (surname == null || name == null || middlename == null || gender == null || date == null)
            throw ValidationException("Incorrect data");
        val student = Student(0,surname,name,middlename,gender,date)
        _validator?.Validate(student, mutableListOf()) == true
        return student
    }
}