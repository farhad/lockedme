package farhadfaghihi.lockedme.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FileOpsManager {

    private ClassLoader classLoader;

    public FileOpsManager() {
        classLoader = ClassLoader.getSystemClassLoader();
    }

    public String readFileInResources(String fileName) throws IOException {
        File file = new File(classLoader.getResource(fileName).getFile());
        return String.join("\n", Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));
    }

    public void clearResources() {
        classLoader = null;
    }
}
