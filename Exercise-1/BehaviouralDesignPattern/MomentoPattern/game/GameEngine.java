package game;

import java.util.Scanner;
import java.util.logging.Logger;

public class GameEngine {
    private static final Logger logger = Logger.getLogger(GameEngine.class.getName());
    private final Player player;
    private final GameHistory history;
    private final int gridSize;
    private boolean running;

    public GameEngine(int gridSize) {
        this.gridSize = gridSize;
        this.player = new Player(gridSize);
        this.history = new GameHistory();
        this.running = true;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
                renderGrid();
                System.out.print("Enter your move (u=up, d=down, l=left, r=right, z=undo, q=quit): ");
                String input = scanner.nextLine().trim().toLowerCase();

                if (input.isEmpty()) continue;
                char command = input.charAt(0);

                switch (command) {
                    case 'u': case 'd': case 'l': case 'r':
                        history.save(player.save()); // save before moving
                        player.move(command);
                        break;

                    case 'z':
                        if (history.hasHistory()) {
                            player.restore(history.undo());
                        } else {
                            logger.warning("No previous state to undo.");
                        }
                        break;

                    case 'q':
                        logger.info("Game exited by user.");
                        running = false;
                        break;

                    default:
                        logger.warning("Invalid command. Please try again.");
                }
            }
        } catch (Exception e) {
            logger.severe("Unexpected error occurred: " + e.getMessage());
        }
    }

    private void renderGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (i == player.getX() && j == player.getY()) {
                    System.out.print("+ ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
