package Commands;

import Running.CONSTANTS;
import Running.LOG_MESSAGES;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class CommandFactory {
    private Properties factoryProperties = new Properties();
    private static Logger logger = getLogger(CommandFactory.class.getName());

    private static volatile CommandFactory instance;

    public static CommandFactory getInstance() throws IOException {
        if (instance == null)
            synchronized (CommandFactory.class)
            {
                if (instance == null) {
                    instance = new CommandFactory();
                }
            }
        return instance;
    }

    private CommandFactory() throws IOException {
        InputStream is = getClass().getResourceAsStream(CONSTANTS.OPERATIONS_DESTINATION);
        if(is == null) {
            logger.info(LOG_MESSAGES.PROPERTIES);
            throw new NullPointerException();
        }
        factoryProperties.load(is);
    }


    public Command createCommand(String operationName) {
        Command command;
        try {
            command = (Command) Class.forName(factoryProperties.getProperty(operationName)).getDeclaredConstructor().newInstance();
            logger.info(LOG_MESSAGES.CREATE_OPERATION + operationName);
        }
        catch (Exception e) {
            logger.info(LOG_MESSAGES.CREATE_OPERATION_ERROR + operationName);
            return null;
        }

        return command;
    }
}
