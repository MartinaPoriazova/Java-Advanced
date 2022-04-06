import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumBytes {

    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Marti\\Desktop\\Advanced_Java\\" +
                "10. Exercise Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        byte[] allBytes = Files.readAllBytes(Path.of(pathString)); // масив с вс аскита
        long sum = 0;

        for (byte value : allBytes) {
            if (value != 10 && value != 13) {
                sum += value; // Брои разделитете т.е. соейсове и нови редове, а не трябва да се броят, не са символи
            }
        }

        System.out.println(sum);
    }
}
