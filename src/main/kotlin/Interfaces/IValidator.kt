package Interfaces

import Exceptions.ValidationException
import javax.xml.validation.Validator

interface IValidator<T> {
    fun Validate(obj: T): List<String>
    fun ThrowValidationError(validationResult: List<String>) {
        if (validationResult.count() > 0) {
            var errorMsg = ""
            validationResult.forEach{
                errorMsg.plus("$it\n")
            }
            throw ValidationException(errorMsg)
        }
    }
}
