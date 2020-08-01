package farhadfaghihi.lockedme;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.Arrays;

public class MainMenuTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void it_shows_the_main_menu_content_when_app_starts() throws IOException {
        // Arrange
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File mainMenuContentFile = new File(classLoader.getResource("content_mainmenu.txt").getFile());
        String mainMenuContent = Arrays.toString(Files.readAllBytes(mainMenuContentFile.toPath()));

        MainMenuManager mainMenuManager = new MainMenuManager();

        // Act
        mainMenuManager.start();

        // Assert
        Assert.assertEquals(mainMenuContent, outContent.toString());
    }
}
