import Exceptions.ValidationException

abstract class Validator<T> {

    public open fun Validate(obj: T, errors: MutableIterable<String>): Boolean {
        try {
            if (errors == null)
                throw IllegalArgumentException()
            if (errors.any())
                ThrowValidationExceptionIfAny(errors)
        } catch (ex: ValidationException) {
            print(ex.message)
            return false
        }
        return true
    }

    public final fun ThrowValidationException() {
        throw ValidationException(null);
    }

    protected final fun ThrowValidationExceptionIfAny(errors: Iterable<String>) {
        var messages = ""
        errors.forEach {
            messages.plus("${it}\n")
        }
        throw ValidationException(messages);
    }

}