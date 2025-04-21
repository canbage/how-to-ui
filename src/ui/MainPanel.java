package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.Toolkit;

import javax.swing.JPanel;

import input.InputStates;
import input.LocalInput;
import main.DebugStats;

public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	DebugStats debugStats;
	LocalInput localInput;
	InputStates inputStates;
	
//	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int SCREEN_WIDTH = 1920;
	public static final int SCREEN_HEIGHT = 1080;
	
	Updatable currentPanel;
	TitleMenuPanel titleMenuPanel;
	HostMenuPanel hostMenuPanel;
	
	public MainPanel(DebugStats debugStats, InputStates inputStates, LocalInput localInput) {
		
		this.debugStats = debugStats;
		
		inputStates = new InputStates();
		localInput = new LocalInput(inputStates);
			
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(localInput);
		
		titleMenuPanel = new TitleMenuPanel(debugStats, this, localInput, inputStates);
		hostMenuPanel = new HostMenuPanel(debugStats, this, localInput, inputStates);
		
		setLayout(new CardLayout());
		add(titleMenuPanel, "Title Menu");
		add(hostMenuPanel, "Host Menu");
		
		switchPanel("Title Menu");
	}
	
	public void switchPanel(String panel) {
		
		CardLayout cardLayout = (CardLayout) getLayout();
		cardLayout.show(this, panel);
		
		switch (panel) {
		case "Title Menu":
			currentPanel = titleMenuPanel;
			break;
		case "Host Menu":
			currentPanel = hostMenuPanel;
			break;
		}
		
		((JPanel) currentPanel).requestFocusInWindow();
	}
	
	public Updatable getCurrentPanel() {
		
		return currentPanel;
	}
}