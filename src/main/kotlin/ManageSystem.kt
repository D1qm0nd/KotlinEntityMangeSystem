import UI.Buttons.ButtonsBuilder
import UI.Buttons.Interfaces.IButtonsPrinter

class ManageSystem<TIButton, TOButton>(
    _buttonsBuilder: ButtonsBuilder<TIButton, TOButton>,
    _buttonsPrinter: IButtonsPrinter,
    _actionScanner: ActionScanner)
{

    private val _menu : ManageSystemMenu<TIButton,TOButton>

    init {
        _menu = ManageSystemMenu<TIButton,TOButton>(_buttonsBuilder.Build(), _buttonsPrinter, _actionScanner)
    }
    public fun StartManage() {
        _menu.Use()
    }
}