package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import input.InputStates;
import input.LocalInput;
import main.DebugStats;
import ui.components.Button;
import ui.components.Label;
import ui.components.PanelButton;
import ui.components.QuitButton;

public class TitleMenuPanel extends JPanel implements Updatable {
	
	DebugStats debugStats;
	MainPanel mainPanel;
	LocalInput localInput;
	InputStates inputStates;
	
	Label titleLabel;
	ButtonSelector buttonSelector;
	Button hostGameButton;
	Button joinGameButton;
	Button settingsButton;
	Button quitButton;

	private static final long serialVersionUID = 1L;
	
	public TitleMenuPanel(DebugStats debugStats, MainPanel mainPanel, LocalInput localInput, InputStates inputStates) {
		
		this.debugStats = debugStats;
		this.mainPanel = mainPanel;
		this.localInput = localInput;
		this.inputStates = inputStates;

		this.setPreferredSize(new Dimension(MainPanel.SCREEN_WIDTH, MainPanel.SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		
		this.requestFocusInWindow();
		
		initializeUI();
	}
	
	public void initializeUI() {
		
		titleLabel = new Label("PONG", MainPanel.SCREEN_WIDTH/2, MainPanel.SCREEN_HEIGHT/2 - 240, 400, 100, 100, 20);
		
		buttonSelector = new ButtonSelector();
		hostGameButton = new PanelButton("HOST GAME", MainPanel.SCREEN_WIDTH/2, MainPanel.SCREEN_HEIGHT/2, mainPanel, "Host Menu");
		joinGameButton = new Button("JOIN GAME", MainPanel.SCREEN_WIDTH/2, MainPanel.SCREEN_HEIGHT/2 + 80);
		settingsButton = new Button("SETTINGS", MainPanel.SCREEN_WIDTH/2, MainPanel.SCREEN_HEIGHT/2 + 160);
		quitButton = new QuitButton("QUIT", MainPanel.SCREEN_WIDTH/2, MainPanel.SCREEN_HEIGHT/2 + 240);
		
		buttonSelector.addButton(hostGameButton);
		buttonSelector.addButton(joinGameButton);
		buttonSelector.addButton(settingsButton);
		buttonSelector.addButton(quitButton);
		
		buttonSelector.updateButton();
	}

	@Override
	public void update() {
		
		if (inputStates.checkKeyInput(InputStates.UP)) {
			inputStates.updateKeyInput(InputStates.UP);
			
			buttonSelector.moveUp();
		}
		
		if (inputStates.checkKeyInput(InputStates.DOWN)) {
			inputStates.updateKeyInput(InputStates.DOWN);
			
			buttonSelector.moveDown();
		}
		
		if (inputStates.checkKeyInput(InputStates.ENTER)) {
			inputStates.updateKeyInput(InputStates.ENTER);
			
			buttonSelector.fireButton();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setTransform(new AffineTransform());
		
		titleLabel.drawLabel(g2);
		hostGameButton.drawButton(g2);
		joinGameButton.drawButton(g2);
		settingsButton.drawButton(g2);
		quitButton.drawButton(g2);
		
		debugStats.drawDebug(g2);
		
		g2.dispose();
	}
}