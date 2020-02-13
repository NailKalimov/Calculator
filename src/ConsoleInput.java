import javax.xml.bind.ValidationException;
import java.util.Scanner;

public class ConsoleInput {
    Scanner scanner = new Scanner(System.in);
    Validator validator = new Validator();

    String startReading() {
        System.out.println("Введите выражение для вычисления\n->");
        String str = scanner.nextLine();
        try {
            validator.checkValidation(str);
        } catch (ValidationException | ArithmeticException e) {
            e.printStackTrace();
            return startReading();
        }
        return str;
    }
}
