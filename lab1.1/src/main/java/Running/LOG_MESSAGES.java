package Running;

import java.io.StringReader;

public interface LOG_MESSAGES {
    public final String PROPERTIES = "Файл operations.properties не найден.";
    public final String START = "Программа начала работу.";
    public final String END = "Программа закончила работу.";
    public final String START_CONSOLE = "Начата работа с консолью.";
    public final String START_FILE = "Начата работа с консолью.";
    public final String DIV_BY_ZERO = "Произошло деление на ноль!";
    public final String CREATE_OPERATION = "Операция успешно создана.";
    public final String CREATE_OPERATION_ERROR = "Операция не создана!";
    public final String BEGIN_OPERATION = "Начало выполнения операции: ";
    public final String END_OPERATION = "Завершение выполнения операции: ";
    public final String INCORRECT_ARGS = "Операция проигнорирована - стек содержит некоректные аргументы";
    public final String WRONG_AMOUNT_OF_ARGS_EXCEPTION = "Некоректное количество аргументов для операции";
    public final String WRONG_AMOUNT_OF_OPERANDS_EXCEPTION = "Некоректное количество операндов для операции";
    public final String EMPTY_STACK = "Операция проигнорирована - стек пуст.";
    public final String INVALID_COMMAND = "Операция проигнорирована - операции не существует: ";
    public final String FILE_NOT_FOUND = "Файл не найден - попробуйте ещё раз.";
}
