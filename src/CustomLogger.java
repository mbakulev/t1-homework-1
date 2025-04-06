import java.io.*;
import java.util.Scanner;

public class CustomLogger {
    private String fileName;
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public CustomLogger(String fileName) {
        try {
            this.fileName = fileName;
            fileWriter = new FileWriter(fileName, true);
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void write(String operation, double firstArgument, double secondArgument, double result) throws IOException {
        String resultString = firstArgument + " " + operation + " " + secondArgument + " = " + result + "\n";
        fileWriter.write(resultString);
    }

    public void read() {
        try  {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public void clearFile() {
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
        }
    }

    public void close() {
        try {
            bufferedReader.close();
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while closing the file.");
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String operation = getOperation(scanner);

        switch (operation) {
            case "READ": this.read(); break;
            case "CLEAR": this.clearFile(); break;
        }
    }

    private String getOperation(Scanner scanner) {
        System.out.println("Введите " + "READ" + " для чтения логов, " + "CLEAR" + " для удаления логов");
        return scanner.nextLine();
    }
}
