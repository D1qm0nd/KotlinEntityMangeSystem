package Models

import ActionScanner
import Models.DataLayer.*

class StudentViewModel(
    _model: Model<Student>,
    _actionScanner: ActionScanner,
    _modelPrinter: ModelPrinter<Student>,
    _modelManipulator: ModelManipulator<Student>, ) : ViewModel<Student>(
        _model,
        _actionScanner,
        _modelPrinter,
        _modelManipulator)
{
    override fun Show(s: String?): Boolean {

        Sort().forEach{
            _modelPrinter.Print(it)
        }
        return true
    }

    final fun Sort() : List<Student>
    {
        val input = _actionScanner.Scan("Sort by (^ - descending): id, surname, name, middlename, gender, birthday, (another for skip sorting): ")
        var context =_model.GetContext();
        when (input?.lowercase()) {
            "^id" -> context = context.sortedByDescending { it.Id }
            "^surname" -> context = context.sortedBy { it.Surname }
            "^name" -> context = context.sortedBy { it.Name }
            "^middlename" -> context = context.sortedBy { it.Middlename }
            "^gender" -> context = context.sortedBy { it.Gender }
            "^birthday" -> context = context.sortedBy { it.BirthDay }

            "id" -> context = context.sortedBy { it.Id }
            "surname" -> context = context.sortedByDescending { it.Surname }
            "name" -> context = context.sortedByDescending { it.Name }
            "middlename" -> context = context.sortedByDescending { it.Middlename }
            "gender" -> context = context.sortedByDescending { it.Gender }
            "birthday" -> context = context.sortedByDescending { it.BirthDay }
        }
        return context
    }
}