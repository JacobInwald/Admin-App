package adminapp.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 128, height = 128;

	public static Font PixelForce20;
	
	public static BufferedImage box;
	public static BufferedImage[] loginButton, memberDeleteButton, memberCreateButton, memberFindButton, backButton;
	
	public static void init() {
		
		PixelForce20 = FontLoader.loadFont("res/fonts/PixelForce.ttf", 20);

		SpriteSheet loginSheet = new SpriteSheet(ImageLoader.loadImage("/textures/LoginSheet.png"));
		SpriteSheet userMainSheet = new SpriteSheet(ImageLoader.loadImage("/textures/UserMainSheet.png"));
		
		loginButton = new BufferedImage[2];
		loginButton[0] = loginSheet.crop(2, 2, width, height);
		loginButton[1] = loginSheet.crop(width, 2, width, height);
		
		memberFindButton = new BufferedImage[2];
		memberFindButton[0] = userMainSheet.crop(2, 2, width, height);
		memberFindButton[1] = userMainSheet.crop(width, 0, width, height);
		
		memberDeleteButton = new BufferedImage[2];
		memberDeleteButton[0] = userMainSheet.crop(width * 2, 0, width, height);
		memberDeleteButton[1] = userMainSheet.crop(width * 3, 0, width, height);

		memberCreateButton = new BufferedImage[2];
		memberCreateButton[0] = userMainSheet.crop(width * 4, 0, width, height);
		memberCreateButton[1] = userMainSheet.crop(width * 5, 0, width, height);
		
		backButton = new BufferedImage[2];
		backButton[0] =  userMainSheet.crop(width * 6, 0, width, height);
		backButton[1] =  userMainSheet.crop(width * 7, 0, width, height);
		
		box = loginSheet.crop(width * 2, 2, width, height);
	}
	
	
}
