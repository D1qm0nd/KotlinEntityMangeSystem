package UI.Interfaces

interface IScanner<T> {
    open abstract fun Scan(message: String?=null) : T?
}