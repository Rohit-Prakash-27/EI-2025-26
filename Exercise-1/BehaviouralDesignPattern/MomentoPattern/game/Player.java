package game;

import java.util.logging.Logger;

public class Player {
    private static final Logger logger = Logger.getLogger(Player.class.getName());
    private int x, y;
    private final int gridSize;

    public Player(int gridSize) {
        this.gridSize = gridSize;
        this.x = 0;
        this.y = 0;
        logger.info("Player initialized at starting position (0,0).");
    }

    public void move(char direction) {
        int newX = x;
        int newY = y;

        switch (direction) {
            case 'u': newX = x - 1; break;
            case 'd': newX = x + 1; break;
            case 'l': newY = y - 1; break;
            case 'r': newY = y + 1; break;
            default:
                logger.warning("Invalid move command: " + direction);
                return;
        }

        if (newX >= 0 && newX < gridSize && newY >= 0 && newY < gridSize) {
            x = newX;
            y = newY;
            logger.info("Player moved to (" + x + "," + y + ")");
        } else {
            logger.warning("Move blocked: (" + newX + "," + newY + ") is outside grid.");
        }
    }

    public GameState save() {
        return new GameState(x, y);
    }

    public void restore(GameState state) {
        this.x = state.getX();
        this.y = state.getY();
        logger.info("Restored to previous checkpoint: (" + x + "," + y + ")");
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
