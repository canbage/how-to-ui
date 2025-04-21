package ui.components;

import ui.MainPanel;

public class PanelButton extends Button {
	
	MainPanel mainPanel;
	String panelName;
	
	public PanelButton(String text, int posX, int posY, MainPanel mainPanel, String panelName) {
		
		super(text, posX, posY);
		this.mainPanel = mainPanel;
		this.panelName = panelName;
	}
	
	@Override
	public void fireButton() {
		
		super.fireButton();
	}
}
