package Models.DataLayer

import ActionScanner

abstract class ViewModel<TModel>(protected val _model : Model<TModel>, protected val _actionScanner : ActionScanner, protected val _modelPrinter : ModelPrinter<TModel>, protected val _modelManipulator: ModelManipulator<TModel>) {
    public final fun Remove(s: String?): Boolean {
        var index = _actionScanner.Scan("index: ")?.toIntOrNull()
        if (index == null)
            return false
        return _model.Remove(index) != null
    }

    public final fun Edit(s: String?): Boolean {
        var index = _actionScanner.Scan("index: ")?.toIntOrNull()
        if (index == null || _model.GetContext().isNullOrEmpty())
            return false
        if ( index < 0 || index > _model.GetContext().size-1)
            return false
        var entity = _model.Get(index)
        _modelManipulator.Edit(entity!!)
        return true
    }

    public final fun Add(s: String?): Boolean {
        return _model.Add()
    }

    public abstract fun Show(s: String?): Boolean
}