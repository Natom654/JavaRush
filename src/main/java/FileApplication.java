import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class FileApplication {

    public static String readFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }

    public static void writeFile(String path, String message) throws IOException {
        Path pathFile = Path.of(path);
        Files.createFile(pathFile);
        Files.writeString(pathFile, message);
    }

    public static String giveNewFileName(String oldFileName, Command command) {
        int dotIndex = oldFileName.lastIndexOf(".");
        return oldFileName.substring(0, dotIndex) + " [" + command + "]" + oldFileName.substring(dotIndex);
    }
}
