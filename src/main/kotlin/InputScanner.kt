import kotlin.system.exitProcess

class InputScanner : IScanner<String?> {

    override fun scan(): String? {
        var input: String? = readlnOrNull() ?: exitProcess(0)
        return input
    }

    fun ScanIndex(message : String?) : Int?
    {
        print(message)
        var index = scan()?.toIntOrNull()
        if (index == null) {
            println("Недопустимый индекс")
            return null
        }
        return index
    }

}