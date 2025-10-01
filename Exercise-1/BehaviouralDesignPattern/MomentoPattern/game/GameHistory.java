package game;

import java.util.Stack;

public class GameHistory {
    private final Stack<GameState> states = new Stack<>();

    public void save(GameState state) {
        states.push(state);
    }

    public GameState undo() {
        if (states.isEmpty()) {
            throw new IllegalStateException("No previous state to restore.");
        }
        return states.pop();
    }

    public boolean hasHistory() {
        return !states.isEmpty();
    }
}
