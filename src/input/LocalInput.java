package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LocalInput implements KeyListener {
	
	InputStates inputStates;

	public LocalInput(InputStates inputStates) {
		
		this.inputStates = inputStates;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		inputStates.keyPressed(keyCode);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		inputStates.keyReleased(keyCode);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
}
