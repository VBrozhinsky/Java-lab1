package Commands;

import MyExceptions.ArgumentsException;
import MyExceptions.CalculatorException;
import MyExceptions.NumberOfArgumentsException;
import MyExceptions.NumberOfOperandsException;
import Running.Storage;

public interface Command {
    public void execute(Storage data, String args) throws CalculatorException, NumberOfArgumentsException, NumberOfOperandsException, ArgumentsException;
    public String getName();
}
