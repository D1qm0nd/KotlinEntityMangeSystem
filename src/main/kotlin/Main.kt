import Models.StudentFactory
import Models.*
import Models.DataLayer.Context
import UI.Buttons.ButtonsBuilder
import java.time.LocalDate
import kotlin.system.exitProcess


fun main() {

    fun Exit(nothing: String?): Boolean {
        exitProcess(0)
    }

    val entities = mutableListOf<Student>()
    repeat(100)
    {
        entities.add(
            Student(
                it,
                "Surname ${it*it}",
                "Name ${it*it}",
                "Middlename ${it*it}",
                if (it % 2 == 0) 'м' else 'ж',
                LocalDate.now()
            )
        )
    }

    val _viewModel = StudentViewModel(
        _model = StudentModel(
            Context<Student>(entities),
            scanner = StudentScanner(
                factory = StudentFactory(
                    validator = StudentValidator()
                )
            )
        ), _actionScanner = ActionScanner(),
        _modelPrinter = StudentPrinter(),
        _modelManipulator = StudentModelManipulator(StudentValidator(), ActionScanner())
    )

    val _buttonsBuilder = ButtonsBuilder<String?, Boolean>()
        .AddButton("exit", ::Exit, false)
        .AddButton("show", _viewModel::Show, false)
        .AddButton("add", _viewModel::Add , false)
        .AddButton("edit", _viewModel::Edit, false)
        .AddButton("remove", _viewModel::Remove, false)

    var manageSystem = ManageSystem<String?, Boolean>(
        _buttonsBuilder,
        _buttonsPrinter = ManageSystemButtonPrinter(),
        _actionScanner = ActionScanner()
    )
    manageSystem.StartManage()
}