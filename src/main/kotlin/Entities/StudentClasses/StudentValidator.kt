package Entities.StudentClasses

import Interfaces.IValidator
import java.time.LocalDate

class StudentValidator : IValidator<Student> {
    override fun Validate(obj: Student): List<String> {
        val errors : MutableList<String> = mutableListOf()
        if (obj.Id < 0)
            errors.add("Id не является допустимым")
        if (obj.Surname.isEmpty() )
            errors.add("Surname не является допустимым")
        if (obj.Name.isEmpty() )
            errors.add("Name не является допустимым")
        if (obj.Middlename.isEmpty() )
            errors.add("Middlename не является допустимым")
        if (!obj.Gender.isLowerCase() || (obj.Gender != 'м' && obj.Gender != 'ж') )
            errors.add("Gender не является допустимым")
        if (obj.BirthDay.isAfter(LocalDate.now()))
            errors.add("Birthday не является допустимым")
        return errors
    }
}
