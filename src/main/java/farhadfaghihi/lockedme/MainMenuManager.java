package farhadfaghihi.lockedme;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;

public class MainMenuManager {
    public void start() {
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File mainMenuContentFile = new File(classLoader.getResource("content_mainmenu.txt").getFile());
            String mainMenuContent = Arrays.toString(Files.readAllBytes(mainMenuContentFile.toPath()));
            System.out.print(mainMenuContent);

        } catch (Exception exc) {
            System.out.println("Execution Terminated");
            System.out.println(exc.getMessage());
            System.exit(-1);
        }
    }
}
