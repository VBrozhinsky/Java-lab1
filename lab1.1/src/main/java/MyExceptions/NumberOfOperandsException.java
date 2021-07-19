package MyExceptions;

import Running.CONSTANTS;

public class NumberOfOperandsException extends CalculatorException {
    public NumberOfOperandsException() {
        super(CONSTANTS.WRONG_AMOUNT_OF_OPERANDS_EXCEPTION);
    }
}
