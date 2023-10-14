package UI

import java.util.function.Predicate

class Button(val Title: String, val lambda: () -> Boolean)
{
    fun Execute() : Boolean {
        return lambda.invoke()
    }
}