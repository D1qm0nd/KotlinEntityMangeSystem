package Models

import ActionScanner
import Models.DataLayer.ModelManipulator
import Validator
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class StudentModelManipulator(private val _validator: Validator<Student>, _actionScanner: ActionScanner) :
    ModelManipulator<Student>(_actionScanner) {
    override fun Edit(model: Student) {
        var editedModel = model.copy()
        var action: String? = null;
        while (action != "exit") {
            action = _actionScanner.Scan("field (surname, name, middlename, gender, birthday) (or exit): ")?.lowercase()
            when (action) {
                "surname" -> editedModel.Surname = _actionScanner.Scan() ?: model.Surname
                "name" -> editedModel.Name = _actionScanner.Scan() ?: model.Name
                "middlename" -> editedModel.Middlename = _actionScanner.Scan() ?: model.Middlename
                "gender" -> editedModel.Gender = EditGender(editedModel).Gender
                "birthday" -> editedModel.BirthDay = EditBirthDay(editedModel).BirthDay
            }
        }
        var errors = mutableListOf<String>()
        if (_validator.Validate(editedModel, errors)) {
            model.Surname = editedModel.Surname
            model.Name = editedModel.Name
            model.Middlename = editedModel.Middlename
            model.Gender = editedModel.Gender
            model.BirthDay = editedModel.BirthDay
        }
    }

    private fun EditBirthDay(model: Student): Student {
        var input: String? = null
        while (input.isNullOrEmpty()) {
            input = _actionScanner.Scan()
        }
        val date = LocalDate.parse(input.trimEnd(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        model.BirthDay = date
        return model
    }

    private fun EditGender(model: Student): Student {
        var input: String? = null
        while (input.isNullOrEmpty()) {
            input = _actionScanner.Scan()
            if (input?.length != 1) input = null
        }
        model.Gender = input[0]
        return model
    }
}
