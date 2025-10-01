package input;

import java.util.HashMap;
import java.util.Map;

public class ControllerAdapter implements Keyboard {
    private final GameController controller;
    private final Map<String, String> mapping = new HashMap<>();

    public ControllerAdapter(GameController controller) {
        this.controller = controller;
        // Defensive: define mappings once
        mapping.put("W", "Up");
        mapping.put("S", "Down");
        mapping.put("A", "Left");
        mapping.put("D", "Right");
        mapping.put("SPACE", "Jump");
    }

    @Override
    public void pressKey(String key) {
        if (mapping.containsKey(key)) {
            controller.pressButton(mapping.get(key));
        } else {
            System.err.println("[Warning] No mapping found for: " + key);
        }
    }
}
