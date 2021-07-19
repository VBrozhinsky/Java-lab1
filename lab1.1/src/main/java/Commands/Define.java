package Commands;

import MyExceptions.ArgumentsException;
import MyExceptions.CalculatorException;
import MyExceptions.NumberOfArgumentsException;
import Running.CONSTANTS;
import Running.LOG_MESSAGES;
import Running.Storage;

import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class Define implements Command {
    public final String comName = CONSTANTS.DEFINE;
    private static Logger logger = getLogger(Define.class.getName());

    @Override
    public void execute(Storage data, String str) throws CalculatorException {
        String[] args;
        Double constValue;
        if(str == null) {
            logger.info(LOG_MESSAGES.WRONG_AMOUNT_OF_ARGS_EXCEPTION);
            throw new NumberOfArgumentsException();
        }
        args = str.split(CONSTANTS.SPACE);
        if(args.length != 2) throw new NumberOfArgumentsException();
        try {
            constValue = Double.valueOf(args[1]);
        } catch (Exception e) {
            logger.info(LOG_MESSAGES.INCORRECT_ARGS);
            throw new ArgumentsException();
        }
        data.setVar(args[0], constValue);
    }

    @Override
    public String getName() {
        return comName;
    }
}
