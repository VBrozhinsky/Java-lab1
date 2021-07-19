package Commands;

import MyExceptions.NumberOfArgumentsException;
import Running.CONSTANTS;
import Running.LOG_MESSAGES;
import Running.Storage;

import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class Pop implements Command {
    public final String comName = CONSTANTS.POP;
    private static Logger logger = getLogger(Pop.class.getName());

    @Override
    public void execute(Storage data, String str) throws NumberOfArgumentsException {
        if(str != null) {
            if(str.split(CONSTANTS.SPACE).length != 0) {
                logger.info(LOG_MESSAGES.WRONG_AMOUNT_OF_ARGS_EXCEPTION);
                throw new NumberOfArgumentsException();
            }

        }

        if(data.valuesSize() > 0) {
            data.popValue();
        }
        else {
            System.out.println(CONSTANTS.BAD_STACK);
            logger.info(LOG_MESSAGES.EMPTY_STACK);
        }
    }

    @Override
    public String getName() {
        return comName;
    }
}
