import javax.xml.bind.ValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    void checkValidation(String inStr) throws ValidationException, ArithmeticException {
        Pattern pattern = Pattern.compile("[^.0123456789*+/-]");
        Matcher matcher = pattern.matcher(inStr);
        if (matcher.find()) {
            throw new ValidationException("Выражение содержит недопустимые символы!" +
                    "(Используйте только положительные числа и операторы /, *, -, +)");
        }

        pattern = Pattern.compile("\\D{2,}");
        matcher = pattern.matcher(inStr);
        if (matcher.find()) {
            throw new ValidationException("Выражение содержит недопустимые символы!" +
                    "(Выражение содержит повторяющиеся знаки арифметических операций)");
        }

        if (inStr.length() == 0) {
            throw new ValidationException("Вы ввели пустую строку!");
        }

        if (inStr.contains("/0")) {
            throw new ArithmeticException("Выражение содержит деление на ноль!");
        }

        if (inStr.charAt(0) == '-') {
            throw new ValidationException("Выражение содержит отрицательное число!");
        }

    }
}
