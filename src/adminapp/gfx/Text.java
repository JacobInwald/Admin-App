package adminapp.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Text {

	public static void drawString(Graphics g, String text, int x2, int y2, boolean centre, Color c, Font font) {
	
		g.setColor(c);
		g.setFont(font);
		int x = x2;
		int y = y2;
		if(centre) {
			FontMetrics fm = g.getFontMetrics(font);
			x = x2 - fm.stringWidth(text) / 2;
			y = (y2 - fm.getHeight() / 2) + fm.getAscent();
		}
		
		g.drawString(text, x, y);
	}
	
}
