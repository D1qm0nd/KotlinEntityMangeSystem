package Entities.StudentClasses

import Interfaces.IPrinter

class StudentPrinter : IPrinter<Student> {
    override fun print(obj: Student) {
        with(obj) {
            println(
                "${Id.toString().padEnd(10, ' ')} ${Surname.padEnd(40, ' ')} ${
                    Name.padEnd(
                        40,
                        ' '
                    )
                } ${Middlename.padEnd(40, ' ')} $Gender $BirthDay"
            )
        }
    }
}