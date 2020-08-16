package farhadfaghihi.lockedme;

import farhadfaghihi.lockedme.utils.FileOpsManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class MainMenuTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    private FileOpsManager fileOpsManager;

    @Before
    public void setUp() {
        fileOpsManager = new FileOpsManager();
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);

        fileOpsManager.clearResources();
    }

    @Test
    public void it_shows_the_main_menu_content_when_app_starts() throws IOException {
        // Arrange
        String mainMenuContent = fileOpsManager.readFileInResources("content_mainmenu.txt");
        MainMenuManager mainMenuManager = new MainMenuManager();

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        // Act
        mainMenuManager.start();

        // Assert
        Assert.assertEquals(mainMenuContent, outContent.toString());
    }
}
