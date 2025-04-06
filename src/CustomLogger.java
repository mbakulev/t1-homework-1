import java.io.*;

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
//            fileWriter.close();
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

    public void clearFile() throws IOException {
        fileWriter = new FileWriter(fileName);
//        fileWriter.close();
    }

    public void close() throws IOException {
        fileWriter.close();
    }
}
