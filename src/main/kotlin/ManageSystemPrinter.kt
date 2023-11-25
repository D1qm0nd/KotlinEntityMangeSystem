import UI.Interfaces.IPrinter

class ManageSystemPrinter : IPrinter<String?> {
    override fun Print(obj: String?) {
        print(obj)
    }
}