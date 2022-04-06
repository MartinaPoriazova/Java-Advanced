import java.io.*;
import java.lang.management.BufferPoolMXBean;

public class WriteEveryThirdLine {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Marti\\Desktop\\Advanced_Java\\9. Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\Marti\\Desktop\\Advanced_Java\\" +
                "9. Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\out-third-line.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

        String line = reader.readLine();

        int count = 1;
        while (line != null) {
            count++;
            line = reader.readLine();
            if (count % 3 == 0) {
                writer.write(line + System.lineSeparator());
            }

        }
        writer.close(); // -
    }
}
