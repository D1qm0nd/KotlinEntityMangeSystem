package Models.DataLayer

import ActionScanner
import UI.Interfaces.IScanner

abstract class ModelManipulator<TModel>(protected val _actionScanner : ActionScanner) {
    abstract fun Edit(model : TModel)
}
