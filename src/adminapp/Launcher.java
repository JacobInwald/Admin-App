package adminapp;

public class Launcher {
	private static final int width = 960;
	private static final int height = 640;
	
	private static App app;
	public static void main(String[] args) {
		app = new App(width, height, "AdminApp");
		app.start();
	}
	
	public static int getHeight() {
		return height;
	}
	
	public static int getWidth() {
		return width;
	}
}
