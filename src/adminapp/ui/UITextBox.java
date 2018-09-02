package adminapp.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import adminapp.Handler;
import adminapp.gfx.Assets;
import adminapp.gfx.Text;

public class UITextBox extends UIObject{

	private BufferedImage image;
	private Handler handler;
	private String text;
	private boolean concealed = false;
	private boolean isWriting = false;
	private String name, concealedText;
	
	public UITextBox(float x, float y, int width, int height, String name,  Handler handler, boolean concealed) {
		super(x, y, width, height);
		this.image = Assets.box;
		this.handler = handler;
		this.name = name;
		this.concealed = concealed;
		concealedText = "";
		text = "";
		bounds.setBounds((int)(x + 8),(int) (y + 26), 118, 56);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, (int) x, (int) y, width, height, null);
		Text.drawString(g, name, (int)(x + 5), (int)(y + 28), false, Color.BLACK, Assets.PixelForce20);
		if(concealed) {
			if(concealedText.length() < text.length()){
				concealedText += "*";
			}
			else if(concealedText.length() > text.length()) {
				concealedText = "";
			}
			Text.drawString(g, concealedText, (int)(x + 10) , (int)(y + 60), false, Color.BLACK, Assets.PixelForce20);

		}
		else {
		Text.drawString(g, text, (int)(x + 10) , (int)(y + 60), false, Color.BLACK, Assets.PixelForce20);
		}
	}

	@Override
	public void onClick() {
		isWriting = true;
		text = "";
	}

	@Override
	public void tick() {
		
		if(isWriting) 
			writing();
		if(handler.getMouseManager().isLeftPressed())
			isWriting = false;

	}

	public void writing() {
		if(text.length() >= 6)
			return;
		
		if(text.length() <= 0) {
			if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_A))
				text = "a";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_B))
				text = "b";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_C))
				text = "c";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_D))
				text = "d";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
				text = "e";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_F))
				text = "f";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_G))
				text = "g";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_H))
				text = "h";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_I))
				text = "i";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_J))
				text = "j";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_K))
				text = "k";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_L))
				text = "l";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_M))
				text = "m";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_N))
				text = "n";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_O))
				text = "o";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_P))
				text = "p";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Q))
				text = "q";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_R))
				text = "r";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S))
				text = "s";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_T))
				text = "t";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_U))
				text = "u";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_V))
				text = "v";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W))
				text = "w";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_X))
				text = "x";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Y))
				text = "y";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Z))
				text = "z";
		}
		else if(text.length() >= 1) {
			if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_A))
				text += "a";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_B))
				text += "b";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_C))
				text += "c";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_D))
				text += "d";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
				text += "e";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_F))
				text += "f";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_G))
				text += "g";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_H))
				text += "h";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_I))
				text += "i";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_J))
				text += "j";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_K))
				text += "k";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_L))
				text += "l";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_M))
				text += "m";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_N))
				text += "n";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_O))
				text += "o";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_P))
				text += "p";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Q))
				text += "q";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_R))
				text += "r";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S))
				text += "s";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_T))
				text += "t";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_U))
				text += "u";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_V))
				text += "v";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W))
				text += "w";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_X))
				text += "x";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Y))
				text += "y";
			else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Z))
				text += "z";
			}
		
		}
	

	public String getText() {
		return text;
	}
	
	
}
