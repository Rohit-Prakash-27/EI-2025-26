import java.util.Scanner;
import java.util.logging.Logger;
import game.*;

public class GameMain {
    private static final Logger logger = Logger.getLogger(GameMain.class.getName());

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter grid size (eg. 5): ");
            int gridSize = scanner.nextInt();

            if (gridSize <= 0) {
                throw new IllegalArgumentException("Grid size must be positive.");
            }

            logger.info("Starting game with grid size: " + gridSize);
            GameEngine engine = new GameEngine(gridSize);
            engine.start();
        } catch (Exception e) {
            logger.severe("Failed to start game: " + e.getMessage());
        }
    }
}
