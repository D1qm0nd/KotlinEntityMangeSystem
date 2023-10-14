package UI

import java.util.function.Predicate

class ButtonsBuilder {
    private var buttons : MutableList<Button> = mutableListOf()

    fun Add(button : Pair<String, () -> Boolean>)
    {
        buttons.add(Button(button.first,button.second))
    }
    fun Build(): List<Button> {
        return this.buttons
    }
}