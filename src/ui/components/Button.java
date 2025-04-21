package ui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Button {
	
	String text;
	Rectangle rectangle;
	
	int posX;
	int posY;
	
	Font font = new Font("Serif", Font.BOLD, 40);
	
	boolean isSelected = false;
	
	int frame = 60;
	
	public Button(String text, int posX, int posY) {
		
		int width = 200;
		
		this.text = text;
		this.rectangle = new Rectangle(posX - width/2, posY - 50/2, width, 50);
		this.posX = posX;
		this.posY = posY;
	}
	
	public void drawButton(Graphics2D g2) {
		
		g2.setFont(font);
		FontMetrics fontMetrics = g2.getFontMetrics();
		
		int textPosX = rectangle.x + (rectangle.width/2 - fontMetrics.stringWidth(text)/2);
		int textPosY = rectangle.y + (rectangle.height/2 - fontMetrics.getHeight()/2) + fontMetrics.getAscent();
		
		g2.setColor(Color.white);
		if (isSelected) {
			if (frame <= 60) {
				animateRectangle(rectangle.width, 300);
				frame++;
			}
			g2.fill(rectangle);
			g2.setColor(Color.black);
		}
		
		g2.drawString(text, textPosX, textPosY);
	}
	
	public void fireButton() {
		
		System.out.println("Firing Button");
	}
	
	public void selectButton() {
		
		isSelected = true;
		frame = 0;
	}
	
	public void deselectButton() {
		
		isSelected = false;
		updateRectangle(200);
	}
	
	public void animateRectangle(int start, int end) {
		
		double t = frame/60.0;
		t = 0.5 * (1 - Math.cos(Math.PI * t));
		double lerp = start + (end - start) * t;
		
		updateRectangle((int) lerp);
	}
	
	public void updateRectangle(int newWidth) {
		
		if (newWidth != -1) {
			rectangle.width = newWidth;
			rectangle.x = (posX - newWidth/2);
		}
	}
}
