package DataLayer

class Repository<T> {
    private val Context : Context<T> = Context()

    fun GetContext() = Context.GetEntites()

    fun Add(item : T){
        Context.Entites.add(item)
    }

    fun Remove(index: Int)
    {
        Context.Entites.removeAt(index)
    }
    fun Update(index : Int) = Context.Entites[index]
}