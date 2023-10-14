package UI

import Exceptions.InvalidButtonsCount
import Exceptions.InvalidOperationException

class ButtonActionManager(private var _buttons : Iterable<Button>? = null) {

    fun SetButtons(buttons : Iterable<Button>) {
        _buttons = buttons
    }

    /// title must be lowercase
    fun DoAction(title : String)
    {
        if (_buttons == null)
            throw InvalidButtonsCount()
        var actionButtons = _buttons!!.filter{  it.Title.lowercase() == title}
        if (actionButtons.firstOrNull() != null || actionButtons.count() == 1)
            actionButtons.forEach{
                if (it.lambda == null)
                    throw InvalidOperationException()
                else {
                    if (!it.lambda.invoke())
                        println("Операция не удалась :(")
                }
            }
        else if (actionButtons.count() > 1)
            throw InvalidButtonsCount()
        else println("Данной операции не существует")
    }
}