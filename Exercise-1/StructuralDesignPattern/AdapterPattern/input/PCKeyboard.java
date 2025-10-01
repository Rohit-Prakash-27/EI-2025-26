package input;

public class PCKeyboard implements Keyboard {
    @Override
    public void pressKey(String key) {
        System.out.println("[Keyboard] Key pressed: " + key);
    }
}
