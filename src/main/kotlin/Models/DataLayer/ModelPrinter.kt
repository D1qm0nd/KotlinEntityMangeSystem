package Models.DataLayer

import UI.Interfaces.IPrinter

open class ModelPrinter<TModel> : IPrinter<TModel>{
    override fun Print(obj: TModel) {
        println(obj)
    }
}
