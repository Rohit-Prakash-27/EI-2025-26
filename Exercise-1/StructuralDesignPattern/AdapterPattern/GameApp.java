import input.*;
import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Available inputs
        Keyboard keyboard = new PCKeyboard();
        Keyboard controllerAdapter = new ControllerAdapter(new GameController());

        System.out.println("Choose input method: 1. Keyboard  2. Controller");
        String choice = sc.nextLine().trim();

        // Defensive: validate choice
        Keyboard input = switch (choice) {
            case "1" -> keyboard;
            case "2" -> controllerAdapter;
            default -> {
                System.err.println("[Error] Invalid choice, defaulting to Keyboard");
                yield keyboard;
            }
        };

        // Loop without hardcoding while(true)
        boolean running = true;
        while (running) {
            System.out.println("Enter command (W/A/S/D/SPACE, type EXIT to quit):");
            String cmd = sc.nextLine().trim().toUpperCase();

            if ("EXIT".equals(cmd)) {
                running = false;
            } else {
                try {
                    input.pressKey(cmd);
                } catch (Exception e) {
                    System.err.println("[Error] Unexpected issue: " + e.getMessage());
                }
            }
        }

        System.out.println("Game session ended.");
        sc.close();
    }

}
