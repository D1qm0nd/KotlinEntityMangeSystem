package Entities.StudentClasses

import Exceptions.InvalidArgumentCount
import Exceptions.ValidationException
import Interfaces.Factory
import Interfaces.IValidator
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class StudentFactory(validator: IValidator<Student>) : Factory<Student>(validator) {
    override fun create(): Student {
        TODO("Not yet implemented")
    }

    override fun create(string: String): Student {
        var args = string.split(",")
        if (args.size != 5)
            throw InvalidArgumentCount("Не верное количество аргументов")
        var student = Student(0, args[0],args[1],args[2],args[3][0], LocalDate.parse(args[4], DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        var validationResult = validator.Validate(student)
        validator.ThrowValidationError(validationResult)
        return student
    }

    fun create(args: Iterable<String>): Student {
        TODO("Not yet implemented")
    }
}