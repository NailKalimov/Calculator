import javax.xml.bind.ValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    void checkValidation(String inStr) throws ValidationException, ArithmeticException {
        Pattern pattern = Pattern.compile("[^.0123456789*+/-]");
        Matcher matcher = pattern.matcher(inStr);
        if (matcher.find()) {
            throw new ValidationException("Выражение содержит недопустимые символы!");
        }
        pattern = Pattern.compile("\\D{2,}");
        matcher = pattern.matcher(inStr);
        if (matcher.find()) {
            throw new ValidationException("Выражение содержит недопустимые символы!");
        }
        if (inStr.charAt(0) == '-') {
            throw new ValidationException("Выражение содержит отрицательное число!");
        }
        if (inStr.contains("/0")) {
            throw new ArithmeticException("Выражение содержит деление на ноль!");
        }
    }
}
