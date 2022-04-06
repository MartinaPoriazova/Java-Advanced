import java.io.File;

public class NestedFolders {

    public static int foldersCount = 0;

    public static void main(String[] args) {
        String fileName = "C:/Users/Marti/Desktop/Advanced_Java/" +
                "9. Streams, Files and Directories/" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";
        File file = new File(fileName);
        dfs(file);
        System.out.println(foldersCount + " folders");
    }

    public static void dfs(File file) {
        // bottom case
        // step
        foldersCount++;
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                dfs(f);
            }
        }
        System.out.println(file.getName());
    }
}
