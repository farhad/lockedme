package farhadfaghihi.lockedme;

import farhadfaghihi.lockedme.utils.FileOpsManager;

public class MainMenuManager {
    public static void main(String[] args) {
        MainMenuManager mainMenuManager = new MainMenuManager();
        mainMenuManager.start();
    }

    public void start() {
        try {
            String mainMenuContent = new FileOpsManager().readFileInResources("content_mainmenu.txt");
            System.out.print(mainMenuContent);

        } catch (Exception exc) {
            System.out.println("Execution Terminated : \n" + exc.getMessage());
            System.exit(-1);
        }
    }
}
