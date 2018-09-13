package adminapp.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import adminapp.gfx.Assets;
import adminapp.gfx.Text;

public class UIBox extends UIObject{

	private String title, text;
	private BufferedImage image;
	
	public UIBox(float x, float y, int width, int height, String title, String text) {
		super(x, y, width, height);
		this.image = Assets.box;
		this.text = text;
		this.title = title;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, width, height, null);
		Text.drawString(g, title,(int) (x + 5), (int)(y + 28), false, Color.BLACK, Assets.PixelForce20);
		Text.drawString(g, text, (int)(x + 10), (int)(y + 60), false, Color.BLACK, Assets.PixelForce20);
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	
	
}
