package Commands;

import MyExceptions.*;
import Running.CONSTANTS;
import Running.LOG_MESSAGES;
import Running.Storage;

import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class Div implements Command{
    public final String comName = CONSTANTS.DIV;
    private static Logger logger = getLogger(Div.class.getName());

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
            arg2 = data.popValue();
            arg1 = data.popValue();
        } catch (Exception e) {
            logger.info(LOG_MESSAGES.INCORRECT_ARGS);
            throw new ArgumentsException();
        }

        if(arg2 == 0.0) {
            logger.info(LOG_MESSAGES.DIV_BY_ZERO);
            throw new DivisionByZeroException();
        }

        double result = arg2 / arg1;
        data.pushValue(result);
    }

    @Override
    public String getName() {
        return comName;
    }
}