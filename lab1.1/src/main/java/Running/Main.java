package Running;

import Commands.Mul;
import MyExceptions.CalculatorException;

import java.io.*;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class Main {
    public static void main(String[] args) throws IOException, CalculatorException {
        //System.out.println(Mul.class.getName());
        Logger logger = getLogger(Main.class.getName());
        Calculator calculator;
        logger.info(LOG_MESSAGES.START);
        InputStream is;
        if(args.length > CONSTANTS.MIN_AMOUNT_OF_ARGS) {
            try {
                is = new FileInputStream(args[0]);
                logger.info(LOG_MESSAGES.START_FILE);
            } catch (FileNotFoundException e) {
                System.out.println(CONSTANTS.NOT_EXISTING_FILE);
                logger.info(LOG_MESSAGES.FILE_NOT_FOUND);
                is = System.in;
                logger.info(LOG_MESSAGES.START_CONSOLE);
            }
        }
        else {
            is = System.in;
            logger.info(LOG_MESSAGES.START_CONSOLE);
        }
        calculator = new Calculator(is);
        calculator.calculate();
        logger.info(LOG_MESSAGES.END);
    }
}
