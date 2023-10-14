package UI

import Interfaces.IPrinter

class Menu(
    private val buttonsBuilder: ButtonsBuilder,
    private val buttonPrinter: IPrinter<Iterable<Button>>,
    private val buttonActionManager: ButtonActionManager
) {
    private lateinit var _buttons : Iterable<Button>
    init {
        _buttons = buttonsBuilder.Build()
        buttonActionManager.SetButtons(_buttons)
    }

    fun show() {
        buttonPrinter.print(_buttons);
    }

    fun DoAction(buttonName: String) {
        buttonActionManager.DoAction(buttonName.lowercase())
    }
}

