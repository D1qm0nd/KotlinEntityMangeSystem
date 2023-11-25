package UI.Buttons

class ButtonsBuilder<T,R> {
    private val _buttons = mutableListOf<Button<T, R>>()

    public fun AddButton(name : String, action : (T) -> R, actionNeedArguments : Boolean) : ButtonsBuilder<T, R>
    {
        _buttons.add(Button(name = name, action = action, actionNeedArguments = actionNeedArguments))
        return this
    }

    public fun Build() : List<Button<T, R>>
    {
        return _buttons
    }
}