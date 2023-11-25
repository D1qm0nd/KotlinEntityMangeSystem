import UI.Interfaces.IMenu
import UI.Buttons.Button
import UI.Buttons.Interfaces.IButtonsHandler
import UI.Buttons.Interfaces.IButtonsPrinter

class ManageSystemMenu<TIButton,TOButton>(override val _buttons : Iterable<Button<TIButton, TOButton>>, var _buttonsPrinter : IButtonsPrinter, var _actionScanner : ActionScanner)
    : IMenu<TIButton, TOButton>
{
    override lateinit var _buttonsHandler: IButtonsHandler<TIButton, TOButton>

    init {
        _buttonsHandler = ManageSystemButtonsHandler(_buttonsPrinter, _actionScanner)
    }

    override fun Use() {
        _buttonsHandler.Handle(_buttons)
    }
}