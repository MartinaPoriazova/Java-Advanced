import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {

    public static void main(String[] args) throws IOException {
        Path input = Paths.get("C:\\Users\\Marti\\Desktop\\Advanced_Java\\9. Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path output = Paths.get("C:\\Users\\Marti\\Desktop\\Advanced_Java\\" +
                "9. Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\output6.txt");
//        List<String> lines = Files.readAllLines(pathInput);
        List<String> lines = Files.readAllLines(input)
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Files.write(output, lines, Charset.defaultCharset());

    }
}
