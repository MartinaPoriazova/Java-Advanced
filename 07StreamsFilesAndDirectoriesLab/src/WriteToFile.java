import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Marti\\Desktop\\Advanced_Java" +
                "\\9. Streams, Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileStream = new FileInputStream(path);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Marti\\Desktop\\Advanced_Java" +
                "\\9. Streams, Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\output.txt");
        Scanner scanner = new Scanner(fileStream);
        PrintWriter writer = new PrintWriter(fileOutputStream);
        int value = fileStream.read();
        Set<Character> punctuation = Set.of(',', '.', '!', '?'); // Може и с add в Hashset

        while (value != -1) {
            char current = (char) value;
            if (!punctuation.contains(current)) {
                System.out.print(current);
                // във файл - writer.print(current)
            }
            value = fileStream.read();
        }
        fileStream.close();

    }
}
