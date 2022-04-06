import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {

    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Marti\\Desktop\\Advanced_Java\\" +
                "10. Exercise Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        Path path = Path.of(pathString);
        List<String> allLines = Files.readAllLines(path);
        PrintWriter writer = new PrintWriter("output_line_number.txt");

        int countRow = 1;
        for (String line : allLines) {
            writer.println(countRow + ". " + line);
            countRow++;
        }
        writer.close();
    }
}
