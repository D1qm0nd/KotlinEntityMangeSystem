package UI.Buttons

import UI.Buttons.Interfaces.IButton

class Button<T,R> : IButton {
    override val Name : String
    override val ActionNeedArguments: Boolean
    var Action : (T) -> R
    constructor(name: String, action : (T) -> R, actionNeedArguments : Boolean)
    {
        Name = name.uppercase();
        Action = action;
        ActionNeedArguments = actionNeedArguments;
    }
    fun Activate(param : T) : R
    {
        return this.Action.invoke(param)
    }
}