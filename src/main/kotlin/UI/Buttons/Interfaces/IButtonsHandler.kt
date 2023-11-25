package UI.Buttons.Interfaces

import UI.Buttons.Button

interface IButtonsHandler<T, R> {
    open fun Handle(buttons : Iterable<Button<T, R>>)
}
