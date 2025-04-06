import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CustomLogger customLogger = new CustomLogger("/home/user/11.txt");

        Calculator calculator = new Calculator(customLogger);
        calculator.start();

        customLogger.close();
    }
}