package main;

import ui.WindowFrame;

public class MainLauncher {
	
	public static void main(String args[]) {
		
		DebugStats debugStats = new DebugStats();
		
		WindowFrame window = new WindowFrame(debugStats);
		
		window.initialize();
	}
}
