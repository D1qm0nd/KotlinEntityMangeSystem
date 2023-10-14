package Entities.StudentClasses

import Exceptions.InvalidOperationException
import Manipulator
import UI.ButtonActionManager
import UI.ButtonPrinter
import UI.ButtonsBuilder
import UI.Menu

class StudentManipulator : Manipulator<Student> {
    private lateinit var buttonsBuilder: ButtonsBuilder
    private lateinit var currentStudent: Student

    constructor() : super(null) {
        menu = Menu(buttonsBuilder, ButtonPrinter(), ButtonActionManager())
    }

    init {
        buttonsBuilder = ButtonsBuilder();
        buttonsBuilder.Add(Pair("Surname", ::EditSurname))
        buttonsBuilder.Add(Pair("Name", ::EditName))
        buttonsBuilder.Add(Pair("Middlename", ::EditMiddlename))
        buttonsBuilder.Add(Pair("Name", ::EditName))
        buttonsBuilder.Add(Pair("Name", ::EditName))
    }

    override fun Manipulate(obj: Student, id: Int?): Student {
        currentStudent = obj
        if (id != null) {
            currentStudent.Id = id;
            return obj
        }
        menu!!.show();
        var action = readlnOrNull()
        if (!action.isNullOrEmpty()) {
//            throw InvalidOperationException()
            menu!!.DoAction(action.lowercase())
        }
        return obj
    }

    fun EditId(obj: Student, id: Int): Boolean {
        obj.Id = id
        return true
    }

    fun EditSurname(): Boolean {
        var newValue = readlnOrNull()
        if (!newValue.isNullOrEmpty()) {
            currentStudent.Surname = newValue
            return true
        }
        return false
    }

    fun EditName(): Boolean {
        return true
    }

    fun EditMiddlename(): Boolean {
        return true
    }
}