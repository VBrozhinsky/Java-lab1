package MyExceptions;

import Running.CONSTANTS;

public class ArgumentsException extends CalculatorException {
    public ArgumentsException() {
        super(CONSTANTS.INCORRECT_ARGS);
    }
}
