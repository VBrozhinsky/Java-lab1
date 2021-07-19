package Commands;

import MyExceptions.ArgumentsException;
import MyExceptions.CalculatorException;
import MyExceptions.NumberOfArgumentsException;
import Running.CONSTANTS;
import Running.LOG_MESSAGES;
import Running.Storage;

import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class Push implements Command {
    public final String comName = CONSTANTS.PUSH;
    private static Logger logger = getLogger(Push.class.getName());

    @Override
    public void execute(Storage data, String str) throws CalculatorException {
        String[] args;
        if (str == null) {
            logger.info(LOG_MESSAGES.WRONG_AMOUNT_OF_ARGS_EXCEPTION);
            throw new NumberOfArgumentsException();
        }

        args = str.split(CONSTANTS.SPACE);
        if(args.length > 1) {
            logger.info(LOG_MESSAGES.WRONG_AMOUNT_OF_ARGS_EXCEPTION);
            throw new NumberOfArgumentsException();
        }

        Double newValue;
        try {
            newValue = data.containsVar(args[0]) ? data.getVar(args[0]) : Double.valueOf(args[0]);
        } catch (Exception e) {
            logger.info(LOG_MESSAGES.INCORRECT_ARGS);
            throw new ArgumentsException();
        }
        data.pushValue(newValue);
    }

    @Override
    public String getName() {
        return comName;
    }
}