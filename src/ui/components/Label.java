package ui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Label {
	
	String text;
	Rectangle rectangle;
	Rectangle border;
	
	Font font;
	
	public Label(String text, int posX, int posY, int sizeX, int sizeY, int fontSize, int borderWidth) {
		
		this.text = text;
		this.rectangle = new Rectangle(posX - sizeX/2, posY - sizeY/2, sizeX, sizeY);
		this.font = new Font("Serif", Font.BOLD, fontSize);
		
		if (borderWidth != -1) {
			this.border = new Rectangle(posX - (sizeX + borderWidth*2)/2, posY - (sizeY + borderWidth*2)/2, sizeX + borderWidth*2, sizeY + borderWidth*2);
		}
	}
	
	public void drawLabel(Graphics2D g2) {
		
		g2.setFont(font);
		FontMetrics fontMetrics = g2.getFontMetrics();
		
		int textPosX = rectangle.x + (rectangle.width/2 - fontMetrics.stringWidth(text)/2);
		int textPosY = rectangle.y + (rectangle.height/2 - fontMetrics.getHeight()/2) + fontMetrics.getAscent();
		
		if (border != null) {
			g2.setColor(Color.white);
			g2.draw(border);
			
			g2.setColor(Color.black);
			g2.draw(rectangle);
		}
		
		g2.setColor(Color.white);
		g2.drawString(text, textPosX, textPosY);
	}
}
