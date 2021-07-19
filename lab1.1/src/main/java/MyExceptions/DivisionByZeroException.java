package MyExceptions;

import Commands.Command;
import Running.CONSTANTS;

public class DivisionByZeroException extends CalculatorException {
    public DivisionByZeroException() { super(CONSTANTS.DIV_BY_ZERO); }
}
