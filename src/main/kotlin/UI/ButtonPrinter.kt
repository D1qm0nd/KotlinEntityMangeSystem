package UI

import Interfaces.IPrinter

class ButtonPrinter : IPrinter<Iterable<Button>> {
    override fun print(obj: Iterable<Button>) {
        obj.forEach{
            print("${it.Title} ")
        }
        println()
    }
}