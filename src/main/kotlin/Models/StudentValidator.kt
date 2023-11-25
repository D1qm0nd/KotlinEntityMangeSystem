package Models

import Validator
import java.time.LocalDate

class StudentValidator : Validator<Student>() {
    override fun Validate(obj : Student, errors: MutableIterable<String>): Boolean {
        if (obj.Id < 0)
            errors.plus("Id не является допустимым")
        if (obj.Surname.isEmpty() )
            errors.plus("Surname не является допустимым")
        if (obj.Name.isEmpty() )
            errors.plus("Name не является допустимым")
        if (obj.Middlename.isEmpty() )
            errors.plus("Middlename не является допустимым")
        if (!obj.Gender.isLowerCase() || (obj.Gender != 'м' && obj.Gender != 'ж') )
            errors.plus("Gender не является допустимым")
        if (obj.BirthDay.isAfter(LocalDate.now()))
            errors.plus("Birthday не является допустимым")
        return super.Validate(obj, errors)
    }



}