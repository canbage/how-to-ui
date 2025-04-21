package ui.components;

public class QuitButton extends Button {

	public QuitButton(String text, int posX, int posY) {
		
		super(text, posX, posY);
	}
	
	@Override
	public void fireButton() {
		
		System.exit(0);
	}
}