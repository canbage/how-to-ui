package input;


import java.awt.event.KeyEvent;
import java.util.HashMap;

public class InputStates {
	
	public static final String UP = "Up";
	public static final String LEFT = "Left";
	public static final String RIGHT = "Right";
	public static final String DOWN = "Down";
	public static final String ENTER = "Enter";
	
	HashMap<Integer, String> keyBinds = new HashMap<>();
	HashMap<String, Boolean> inputStates = new HashMap<>();
	
	{
		keyBinds.put(KeyEvent.VK_W, UP);	 	// Default: W
		keyBinds.put(KeyEvent.VK_A, LEFT);		// Default: A
		keyBinds.put(KeyEvent.VK_D, RIGHT);		// Default: D
		keyBinds.put(KeyEvent.VK_S, DOWN);		// Default: S
		keyBinds.put(KeyEvent.VK_ENTER, ENTER);
		
		for (String input : keyBinds.values()) {
			inputStates.put(input, false);
		}
	}
	
	public HashMap<String, Boolean> getInputStates() {
		
		return inputStates;
	}
	
	public void keyPressed(int keyCode) {
		
		String input = keyBinds.get(keyCode);
		
		if (input != null) {
			inputStates.replace(input, true);
		}
	}
	
	public void keyReleased(int keyCode) {
		
		String input = keyBinds.get(keyCode);
		
		if (input != null) {
			inputStates.replace(input, false);
		}
	}
	
	public boolean checkKeyInput(String input) {
		
		return inputStates.get(input);
	}
	
	public void updateKeyInput(String input) {
		
		inputStates.replace(input, false);
	}
	
	public void rebindKey(String input, int keyCode) {} // yeahh im not doing this right now
}
