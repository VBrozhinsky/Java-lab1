package Running;

import Commands.Command;
import Commands.CommandFactory;
import MyExceptions.CalculatorException;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class Calculator {
    private Storage data = new Storage();
    private Scanner scanner;
    private static Logger logger = getLogger(Calculator.class.getName());

    public Calculator(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    void calculate() throws IOException, CalculatorException {
        CommandFactory commandFactory = CommandFactory.getInstance();
        String str;
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();

            if(str.length() < CONSTANTS.MIN_AMOUNT_OF_SYMBOLS || str.charAt(CONSTANTS.FIRST_SYMBOL) == CONSTANTS.COMMENT) {
                continue;
            }

            String[] lineElements = str.split(CONSTANTS.SPACE, CONSTANTS.SPACES_LIMIT);

            Command command = commandFactory.createCommand(lineElements[0]);
            if(command != null) {
                logger.info(LOG_MESSAGES.BEGIN_OPERATION + command.getName());
                command.execute(data, lineElements.length > CONSTANTS.MIN_AMOUNT_OF_ELEMENTS ? lineElements[1] : null);
                logger.info(LOG_MESSAGES.END_OPERATION + command.getName());
            }
            else {
                System.out.println(CONSTANTS.WRONG_COMMAND + command.getName());
                logger.warning(LOG_MESSAGES.INVALID_COMMAND + command.getName());
            }
        }
    }
}