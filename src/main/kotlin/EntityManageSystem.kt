import DataLayer.Repository
import Interfaces.IPrinter
import UI.*
import java.util.function.Predicate
import kotlin.system.exitProcess

class EntityManageSystem<T> : ManageSystem {

    private val _buttonsBuilder: ButtonsBuilder = ButtonsBuilder()
    private val _repository: Repository<T>
    private val _studentPrinter: IPrinter<T>
    private val _studentScanner: IScanner<T>
    private val _studentManipulator: Manipulator<T>
    private val _inputScanner : InputScanner

    constructor(
        buttonPrinter: IPrinter<Iterable<Button>>,
        buttonActionManager: ButtonActionManager,
        studentRepository: Repository<T>,
        studentPrinter: IPrinter<T>,
        studentScanner: IScanner<T>,
        studentManipulator: Manipulator<T>,
        inputScanner : InputScanner
    ) : super(null) {
        menu = Menu(_buttonsBuilder, buttonPrinter, buttonActionManager)
        _repository = studentRepository
        _studentPrinter = studentPrinter
        _studentScanner = studentScanner
        _studentManipulator = studentManipulator
        _inputScanner = inputScanner
    }

    init {
        _buttonsBuilder.Add(Pair("Show", ::ShowTable))
        _buttonsBuilder.Add(Pair("Add", ::Add))
        _buttonsBuilder.Add(Pair("Edit", ::Manipulate))
    }

    private fun Manipulate(): Boolean {
        print("index: ")
        var inputIndex = readlnOrNull()
        if (inputIndex.isNullOrEmpty())
            return false
        var index = inputIndex.toIntOrNull() ?: return false
        if (index > _repository.GetContext().size - 1) return false
        _studentManipulator.Manipulate(_repository.Update(index))
        return true
    }

    private fun Add(): Boolean {
        try {
            var item = _studentScanner.scan()
            _studentManipulator.Manipulate(item,_repository.GetContext().size+1)
            _repository.Add(item)
            return true

        } catch (ex: Exception) {
            println(ex.message)
            return true
        }
    }

    private fun ShowTable(): Boolean {

        val maxIndex = _repository.GetContext().size-1;
        val fromIndex = _inputScanner.ScanIndex("Начальный индекс: ") ?: return false
        if (fromIndex < 0)
        {
            println("Недопустимый индекс")
            return false
        }
        var toIndex = _inputScanner.ScanIndex("Конечный индекс: ") ?: return false
        if (toIndex == null){
            println("Недопустимый индекс")
            return false
        }

        if (toIndex > maxIndex)
        {
            println("Недопустимый индекс, максимальный индекс: $maxIndex")
            return false
        }

        var context = _repository.GetContext();
        for (i in fromIndex..toIndex)
            _studentPrinter.print(context[i])
        return true
    }
}