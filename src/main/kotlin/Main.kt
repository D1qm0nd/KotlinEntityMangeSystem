import DataLayer.Repository
import Entities.StudentClasses.*
import UI.*

fun main(args: Array<String>) {
    var system = EntityManageSystem<Student>(
        ButtonPrinter(),
        ButtonActionManager(),
        Repository(),
        StudentPrinter(),
        StudentScanner(
            StudentFactory(
                StudentValidator()
            )
        ),
        StudentManipulator(),
        InputScanner()
    )
    system.startManage ()
}

