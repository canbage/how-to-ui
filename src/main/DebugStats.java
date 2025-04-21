package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class DebugStats {
	
	int fps;
	
	Font font = new Font("SansSerif", Font.PLAIN, 15);
	
	public void updateFPS(int currentFPS) {
		fps = currentFPS;
	}
	
	public void drawDebug(Graphics2D g2) {
		
		g2.setFont(font);
		
		g2.setColor(Color.white);
		
		g2.drawString("CURRENT FPS: " + fps, 10, 20);
	}
}
