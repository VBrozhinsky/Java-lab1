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

public class Sqrt implements Command {
    public final String comName = CONSTANTS.SQRT;
    private static Logger logger = getLogger(Sqrt.class.getName());
    @Override
    public void execute(Storage data, String str) throws CalculatorException {
        if(str != null) {
            if(str.split(CONSTANTS.SPACE).length != 0) {
                logger.info(LOG_MESSAGES.WRONG_AMOUNT_OF_ARGS_EXCEPTION);
                throw new NumberOfArgumentsException();
            }
        }

        if(data.valuesSize() < 1) {
            logger.info(LOG_MESSAGES.WRONG_AMOUNT_OF_OPERANDS_EXCEPTION);
            throw new NumberOfOperandsException();
        }

        Double arg;
        try {
            arg = data.popValue();
        } catch (Exception e) {
            logger.info(LOG_MESSAGES.INCORRECT_ARGS);
            throw new ArgumentsException();
        }

        if(arg < 0.0) {
            logger.info(LOG_MESSAGES.INCORRECT_ARGS);
            throw new ArgumentsException();
        }

        double result = Math.sqrt(arg);
        data.pushValue(result);
    }

    @Override
    public String getName() {
        return comName;
    }
}