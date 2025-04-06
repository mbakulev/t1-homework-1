import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CustomLogger customLogger = new CustomLogger("/home/user/log.txt");
        Calculator calculator = new Calculator(customLogger);

        MenuManager menuManager = new MenuManager(calculator, customLogger);
        menuManager.start();

        customLogger.close();
    }
}