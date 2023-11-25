import UI.Buttons.Button
import UI.Buttons.Interfaces.IButtonsHandler
import UI.Buttons.Interfaces.IButtonsPrinter
import org.jetbrains.annotations.Nullable

class ManageSystemButtonsHandler<TIButton,TOButton>(
    private val _buttonsPrinter: IButtonsPrinter,
    private val _actionScanner: ActionScanner,
) : IButtonsHandler<TIButton, TOButton>  {
    override fun Handle(buttons: Iterable<Button<TIButton, TOButton>>) {
        var actionName: String? = null
        while (actionName != "EXIT") {
            _buttonsPrinter.Print(buttons)
            actionName = _actionScanner.Scan("\nButton: ");
            if (actionName != null)
            {
                buttons.forEach {
                    if (it.Name.equals(actionName!!.uppercase()))
                        it.Action.invoke(null as TIButton)
                }
            }
            actionName = null
        }
    }
}