package Models.DataLayer

abstract class Model<TModel>(protected val Context: Context<TModel>, protected val _scanner: ModelScanner<TModel>) {

    abstract fun Add(obj : TModel) : Boolean
    abstract fun Add() : Boolean
    abstract fun Remove(obj : TModel) : Boolean
    abstract fun Remove(index : Int) : TModel?
    abstract fun Get(index: Int) : TModel?

    fun GetContext() : List<TModel> = Context.Entities //List, to discard foreign edit

}