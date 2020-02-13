import java.util.LinkedList;
import java.util.regex.Pattern;

public class Parser {
    int getPriority(String c) {
        switch (c) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }

    static boolean isDecimal(String c) {
        return Pattern.matches("\\d+(.\\d+)?", c);
    }

    static boolean isBinaryOperator(String c) {
        return Pattern.matches("[*+/-]", c);
    }

    LinkedList<String> rpnConstructor(String s) {
        String[] str = s.split("(?=[/*+-])|(?<=[/*+-])");
        LinkedList<String> st = new LinkedList<>();
        LinkedList<String> out = new LinkedList<>();
        for (String value : str) {
            if (isDecimal(value)) {
                out.add(value);
            } else if (isBinaryOperator(value)) {
                if (!st.isEmpty() && getPriority(st.getLast()) >= getPriority(value)) {
                    out.add(st.removeLast());
                }
                st.add(value);
            }
        }
        while (!st.isEmpty()) {
            out.add(st.removeLast());
        }
        return out;
    }
}
