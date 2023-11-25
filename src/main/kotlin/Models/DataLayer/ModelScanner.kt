package Models.DataLayer

import Factory
import UI.Interfaces.IScanner

abstract class ModelScanner<TModel>(protected val factory: Factory<TModel>) : IScanner<TModel> {

}
