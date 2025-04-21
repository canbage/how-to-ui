package ui;

import java.util.ArrayList;
import java.util.List;

import ui.components.Button;

public class ButtonSelector {
	
	int currentButton = 0;
	int previousButton = -1;
	
	List<Button> buttonList = new ArrayList<>();
	
	public void addButton(Button button) {
		
		buttonList.add(button);
	}
	
	public void moveUp() {
		
		if (currentButton != 0) {
			previousButton = currentButton;
			currentButton--;
			updateButton();
		}
	}
	
	public void moveDown() {
		
		if (currentButton < buttonList.size() - 1) {
			previousButton = currentButton;
			currentButton++;
			updateButton();
		}
	}
	
	public void updateButton() {
		
		if (previousButton != -1) {
			buttonList.get(previousButton).deselectButton();
		}
		buttonList.get(currentButton).selectButton();
	}
	
	public void fireButton() {
		
		buttonList.get(currentButton).fireButton();
	}
}