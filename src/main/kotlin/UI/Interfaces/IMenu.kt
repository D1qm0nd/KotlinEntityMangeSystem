package UI.Interfaces

import UI.Buttons.Button
import UI.Buttons.Interfaces.IButtonsHandler

interface IMenu<T,R> {
    val _buttons : Iterable<Button<T, R>>
    var _buttonsHandler: IButtonsHandler<T,R>
    abstract fun Use()
}