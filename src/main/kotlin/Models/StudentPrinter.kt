package Models

import Models.DataLayer.ModelPrinter

class StudentPrinter : ModelPrinter<Student>() {
    override fun Print(obj: Student) {
        println(
            "${obj.Id.toString().padEnd(10, ' ')}| ${
                obj.Surname.padEnd(60, ' ')}| ${
                obj.Name.padEnd(40,' ')}| ${
                obj.Middlename.padEnd(40, ' ')}| ${
                obj.Gender.toString().padEnd(2,' ')}| ${
                obj.BirthDay.toString().padEnd(10, ' ')}"
        )
    }
}