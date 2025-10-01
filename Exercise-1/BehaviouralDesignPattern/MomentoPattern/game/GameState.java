package game;
public class GameState {
    private final int x;
    private final int y;

    public GameState(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
