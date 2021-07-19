package Commands;

import MyExceptions.CalculatorException;
import MyExceptions.NumberOfArgumentsException;
import Running.CONSTANTS;
import Running.LOG_MESSAGES;
import Running.Storage;

import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class Print implements Command{
    public final String comName = CONSTANTS.PRINT;
    private static Logger logger = getLogger(Print.class.getName());

    @Override
    public void execute(Storage data, String str) throws CalculatorException {
        if(str != null) {
            if(str.split(CONSTANTS.SPACE).length != 0) {
                logger.info(LOG_MESSAGES.WRONG_AMOUNT_OF_ARGS_EXCEPTION);
                throw new NumberOfArgumentsException();
            }
        }

        System.out.println(data.peekValue());
    }

    @Override
    public String getName() {
        return comName;
    }
}