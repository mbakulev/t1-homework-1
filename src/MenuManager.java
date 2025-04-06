import java.util.Scanner;

public class MenuManager {

    Calculator calculator;
    CustomLogger logger;

    public MenuManager(Calculator calculator, CustomLogger logger) {
        this.calculator = calculator;
        this.logger = logger;
    }

    private boolean isRegimeAccepted(String regime) {
        return regime.equals("1") || regime.equals("2");
    }

    private void runRegime(String regime) {
        switch (regime) {
            case "1":{
                calculator.start();
                break;
            }
            case "2": {
                logger.start();
                break;
            }
            default: {
                System.out.println("Не надо так");
            }
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String regime = "";

        while(!isRegimeAccepted(regime)) {
            regime = getRegime(scanner);
        }

        runRegime(regime);
    }

    private String getRegime(Scanner scanner) {
        System.out.println("Введите 1 для калькулятора, 2 для логов");
        return scanner.nextLine();
    }
}
