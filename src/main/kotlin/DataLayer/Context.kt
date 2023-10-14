package DataLayer

class Context<T> {
    var Entites : MutableList<T> = mutableListOf()

    fun GetEntites() = Entites as List<T>
}