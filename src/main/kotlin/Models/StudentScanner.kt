package Models

import Factory
import Models.DataLayer.ModelScanner

class StudentScanner(factory: Factory<Student>) : ModelScanner<Student>(factory = factory) {

    override fun Scan(message: String?): Student {
        val list = arrayListOf<String?>()
        listOf("Surname", "Name","Middlename","Gender","BirthDate").forEach{
            print("${it}: ")
            list.add(readlnOrNull())
        }
        return factory.Create(list)
    }
}
