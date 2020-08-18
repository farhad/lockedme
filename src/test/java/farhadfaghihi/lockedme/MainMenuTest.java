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

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);

        fileOpsManager.clearResources();
    }

    @Test
    public void it_shows_the_welcome_message_correctly() throws IOException {
        // Arrange
        String welcomeMessage = fileOpsManager.readFileInResources("welcome.txt");

        // Act
        MainMenuManager mainMenuManager = new MainMenuManager();
        mainMenuManager.showWelcomeMessage();

        // Assert
        Assert.assertEquals(welcomeMessage, outContent.toString());
    }
}
