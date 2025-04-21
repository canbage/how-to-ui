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

public class HostMenuPanel extends JPanel implements Updatable {
	
	DebugStats debugStats;
	MainPanel mainPanel;
	LocalInput localInput;
	InputStates inputStates;
	
	Button test;

	private static final long serialVersionUID = 1L;
	
	public HostMenuPanel(DebugStats debugStats, MainPanel mainPanel, LocalInput localInput, InputStates inputStates) {
		
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
		
		test = new Button("Red Button", MainPanel.SCREEN_WIDTH/2, MainPanel.SCREEN_HEIGHT/2);
	}

	@Override
	public void update() {
		
		if (inputStates.checkKeyInput(InputStates.DOWN)) {
			inputStates.updateKeyInput(InputStates.DOWN);
			System.out.println("Down pressed");
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setTransform(new AffineTransform());
		
		test.drawButton(g2);
		
		debugStats.drawDebug(g2);
		
		g2.dispose();
	}
}
