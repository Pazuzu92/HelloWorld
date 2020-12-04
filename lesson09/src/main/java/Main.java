import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) throws IOException {
        Path pathFrom = Paths.get(args[0]);
        Path pathTo = Paths.get(args[1]);
        Files.copy(pathFrom, pathTo, StandardCopyOption.REPLACE_EXISTING);
    }
}
