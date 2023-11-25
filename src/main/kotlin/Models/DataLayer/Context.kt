package Models.DataLayer

import Models.Student

open class Context<T> {

    var Entities : MutableList<T> = mutableListOf()
    constructor(entities: MutableList<T>)
    {
        Entities = entities
    }
    constructor() {}
}