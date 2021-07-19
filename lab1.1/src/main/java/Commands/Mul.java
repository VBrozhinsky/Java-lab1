package Commands;

import MyExceptions.ArgumentsException;
import MyExceptions.CalculatorException;
import MyExceptions.NumberOfArgumentsException;
import MyExceptions.NumberOfOperandsException;
import Running.CONSTANTS;
import Running.LOG_MESSAGES;
import Running.Storage;

import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class Mul implements Command {
    public final String comName = CONSTANTS.MUL;
    private static Logger logger = getLogger(Mul.class.getName());

    @Override
    public void execute(Storage data, String str) throws CalculatorException {
        if(str != null) {
            if(str.split(CONSTANTS.SPACE).length != 0) {
                logger.info(LOG_MESSAGES.WRONG_AMOUNT_OF_ARGS_EXCEPTION);
                throw new NumberOfArgumentsException();
            }
        }

        if(data.valuesSize() < 2) {
            logger.info(LOG_MESSAGES.WRONG_AMOUNT_OF_OPERANDS_EXCEPTION);
            throw new NumberOfOperandsException();
        }

        Double arg1;
        Double arg2;
        try {
            arg1 = data.popValue();
            arg2 = data.popValue();
        } catch (Exception e) {
            logger.info(LOG_MESSAGES.INCORRECT_ARGS);
            throw new ArgumentsException();
        }

        double result = arg1 * arg2;
        data.pushValue(result);
    }

    @Override
    public String getName() {
        return comName;
    }
}