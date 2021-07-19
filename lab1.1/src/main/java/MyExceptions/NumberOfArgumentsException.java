package MyExceptions;

import Running.CONSTANTS;

public class NumberOfArgumentsException extends CalculatorException {
    public NumberOfArgumentsException() {
        super(CONSTANTS.WRONG_AMOUNT_OF_ARGS_EXCEPTION);
    }
}
