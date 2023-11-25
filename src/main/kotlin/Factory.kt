abstract class Factory<T>(protected val _validator : Validator<T>?) {
    public open abstract fun Create() : T
    public open abstract fun Create(params: List<String?>) : T
}