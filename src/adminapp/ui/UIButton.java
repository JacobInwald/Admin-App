package adminapp.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class UIButton extends UIObject{

	private BufferedImage[] image;
	private ClickListener clicker;
	
	public UIButton(float x, float y, int width, int height, BufferedImage[] image, ClickListener clicker) {
		super(x, y, width, height);
		this.image = image;
		this.clicker = clicker;
	}

	@Override
	public void render(Graphics g) {
		if(hovering) {
			g.drawImage(image[1], (int) x, (int) y, width, height, null);
		}
		else {
			g.drawImage(image[0], (int) x, (int) y, width, height, null);
		}
		
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
