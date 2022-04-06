import java.io.File;
import java.io.IOException;

public class GetFolderSize {

    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Marti\\Desktop\\Advanced_Java\\10. Exercise Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(pathString);
        File[] files = folder.listFiles();
        int folderSize = 0;

        for (File file : files) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);

    }
}
