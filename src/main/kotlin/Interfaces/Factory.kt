package Interfaces;

abstract class Factory<T>(protected val validator : IValidator<T>) {
    abstract open fun create() : T
    abstract open fun create(string : String) : T

}
