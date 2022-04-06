import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CopyBytes {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = "C:\\Users\\Marti\\Desktop\\Advanced_Java" +
                "\\9. Streams, Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("out-as-bytes.txt");
        int value = inputStream.read();

        PrintStream out = new PrintStream(outputStream);

        while (value != -1) {
            if (value != 10 && value != 32) {
                System.out.print(value);
            } else {
                System.out.print((char) value);
            }
            value = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
