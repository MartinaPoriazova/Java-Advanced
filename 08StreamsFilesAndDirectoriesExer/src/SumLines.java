import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumLines {

    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Marti\\Desktop\\Advanced_Java\\" +
                "10. Exercise Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        Path path = Path.of(pathString);
        List<String> allLines = Files.readAllLines(path);

        allLines.stream().map(String::toCharArray).forEach(
                charArray -> {
                    int sum = 0;
                    for (char symbol : charArray) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                }
        );

//
//
//        for (String line:allLines) {
//            int sum = 0;
//            for (int index = 0; index < line.length(); index++) {
//                char currentSymbol = line.charAt(index);
//                sum += currentSymbol;
//            }
//            System.out.println(sum);
//        }
//
//

    }
}
