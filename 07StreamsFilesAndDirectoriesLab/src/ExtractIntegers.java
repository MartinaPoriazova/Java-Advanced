import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Marti\\Desktop\\Advanced_Java\\9. Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        String output = "C:\\Users\\Marti\\Desktop\\Advanced_Java\\9. Streams, Files and Directories\\output.txt";
        FileOutputStream outputStream = new FileOutputStream(output);

        Scanner scanner = new Scanner(inputStream);
        PrintWriter printWriter = new PrintWriter(outputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                printWriter.println(number);
                printWriter.flush();
            } else {
                scanner.next();
            }
        }

    }
}

