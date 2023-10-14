package Entities.StudentClasses

import IScanner
import Interfaces.Factory

class StudentScanner(val factory : Factory<Student>) : IScanner<Student> {
    override fun scan(): Student {
        print("Student(value,value,value,value,value): ")
        var input = readlnOrNull()
        if (!input.isNullOrEmpty())
            return factory.create(input)
        TODO("Not yet implemented")
    }
}