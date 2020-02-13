import javax.xml.bind.ValidationException;
import java.util.regex.Pattern;

public class Validator {
    void checkValidation(String inStr) throws ValidationException, ArithmeticException {
        if (Pattern.matches("[^.0123456789/*-+]", inStr)) {
            throw new ValidationException("Выражение содержит недопустимые символы!");
        }
        if (inStr.contains("/0")) {
            throw new ArithmeticException("Выражение содержит деление на ноль!");
        }
        if (inStr.contains("++") || inStr.contains("--")) {
            throw new ValidationException("Выражение не может содержать дублирующиеся символы операций.");
        }
        if (inStr.charAt(0) == '-') {
            throw new ValidationException("Выражение содержит отрицательное число!");
        }
    }
}
