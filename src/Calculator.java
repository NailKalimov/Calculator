import java.util.LinkedList;
import java.util.Stack;

public class Calculator {
    private Double a;
    private Double b;
    Stack<Double> st = new Stack();

    String getResult(LinkedList<String> incomingStr) {
        for (String s : incomingStr) {
            if (Parser.isDecimal(s)) {
                st.push(Double.parseDouble(s));
            } else {
                b = st.pop();
                a = st.pop();
                switch (s) {
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
        }
        return st.peek().toString();
    }
}

