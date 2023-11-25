package UI.Buttons.Interfaces

import UI.Interfaces.IPrinter

interface IButtonsPrinter : IPrinter<IButton> {
    open override fun Print(obj: IButton) {
        print("[${obj.Name}] ")
    }

    open fun Print(obj: Iterable<IButton>) {
        obj.forEach {
            Print(it)
        }
    }
}
