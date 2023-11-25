import UI.Interfaces.IScanner

class ActionScanner : IScanner<String> {
    override fun Scan(message: String?): String? {
        if (message != null)
            print(message)
        return readlnOrNull()
    }
}
