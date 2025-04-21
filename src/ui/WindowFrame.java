package ui;

import javax.swing.JFrame;

import input.InputStates;
import input.LocalInput;
import main.DebugStats;
import main.FrameThread;

public class WindowFrame {
	
	DebugStats debugStats;
	
	public WindowFrame(DebugStats debugStats) {
		
		this.debugStats = debugStats;
	}
	
	public void initialize() {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setUndecorated(true);
		window.setResizable(false);
		window.setTitle("I am netcode");
		
		InputStates inputStates = new InputStates();
		LocalInput localInput = new LocalInput(inputStates);
		MainPanel mainPanel = new MainPanel(debugStats, inputStates, localInput);
		FrameThread frameThread = new FrameThread(debugStats, mainPanel);
		
		window.add(mainPanel);
		
		mainPanel.requestFocusInWindow();
		
		window.addKeyListener(localInput);
		
		frameThread.startFrameThread();
		
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
