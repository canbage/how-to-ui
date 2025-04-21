package main;

import javax.swing.JPanel;

import ui.MainPanel;
import ui.Updatable;

public class FrameThread implements Runnable {
	
	DebugStats debugStats;
	MainPanel mainPanel;
	
	Thread frameThread;
	
	final int targetUpdateFps = 60;
	
	public FrameThread(DebugStats debugStats, MainPanel mainPanel) {
		
		this.debugStats = debugStats;
		this.mainPanel = mainPanel;
	}

	public void startFrameThread() {
		
		frameThread = new Thread(this);
		
		frameThread.start();
	}
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/targetUpdateFps;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(frameThread != null) {
			
			Updatable currentPanel = mainPanel.getCurrentPanel();
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			
			timer += (currentTime - lastTime);
			
			lastTime = currentTime;
			
			if (delta >= 1) {
				currentPanel.update();
				((JPanel) currentPanel).repaint();
				delta--;
				drawCount++;
			}
			
			if (timer >= 1000000000) {
				debugStats.updateFPS(drawCount);
				drawCount = 0;
				timer = 0;
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
