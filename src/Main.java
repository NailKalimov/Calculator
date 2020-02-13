public class Main {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        Parser parser = new Parser();
        Calculator calculator = new Calculator();
        System.out.println(calculator.getResult(parser.rpnConstructor(consoleInput.startReading())));
    }
}
