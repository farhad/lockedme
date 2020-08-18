package farhadfaghihi.lockedme;

import farhadfaghihi.lockedme.utils.FileOpsManager;

import java.util.Scanner;

public class MainMenuManager {
    public static void main(String[] args) {
        MainMenuManager mainMenuManager = new MainMenuManager();
        mainMenuManager.showWelcomeMessage();
        mainMenuManager.showMainMenu();
    }

    public void showWelcomeMessage() {
        try {
            String welcomeMessage = new FileOpsManager().readFileInResources("welcome.txt");
            System.out.print(welcomeMessage);

        } catch (Exception exception) {
            System.out.println("Execution Terminated : \n" + exception.getMessage());
            System.exit(-1);
        }
    }

    public void showMainMenu() {
        try {
            String mainMenuContent = new FileOpsManager().readFileInResources("mainmenu.txt");
            System.out.print(mainMenuContent);

            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            if (input.equals("1")) {
                showSearchMenu();
            } else {
                System.out.println("Try again?");
                showMainMenu();
            }

        } catch (Exception exc) {
            System.out.println("Execution Terminated : \n" + exc.getMessage());
            System.exit(-1);
        }
    }

    public void showSearchMenu() {
        try {
            String mainMenuContent = new FileOpsManager().readFileInResources("searchmenu.txt");
            System.out.print(mainMenuContent);

            Scanner scanner = new Scanner(System.in);

        } catch (Exception exc) {
            System.out.println("Execution Terminated : \n" + exc.getMessage());
            System.exit(-1);
        }
    }
}
