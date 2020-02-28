import java.util.LinkedList;
import java.util.Stack;

public class Calculator {
    Stack<Double> st = new Stack<>();

    void processOperation(String operator) {
        Double b = st.pop();
        Double a = st.pop();
        switch (operator) {
            case "*":
                st.push(a * b);
                break;
            case "/":
                st.push(a / b);
                break;
            case "-":
                st.push(a - b);
                break;
            case "+":
                st.push(a + b);
                break;
        }
    }

    String getResult(LinkedList<String> incomingStr) {
        for (String s : incomingStr) {
            if (Parser.isDecimal(s)) {
                st.push(Double.parseDouble(s));
            } else {
                processOperation(s);
            }
        }
        return st.peek().toString();
    }
}

