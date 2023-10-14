import UI.Menu

abstract class Manipulator<T>(var menu : Menu?) {
    abstract fun Manipulate(obj : T, id : Int? = null) : T
}