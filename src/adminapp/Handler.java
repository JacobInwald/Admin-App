package adminapp;

import adminapp.input.KeyManager;
import adminapp.input.MouseManager;

public class Handler {

	private App app;
	
	public Handler(App app) {
		this.app = app;
	}
	
	public KeyManager getKeyManager() {
		return app.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return app.getMouseManager();
	}

	public App getApp() {
		return app;
	}
	
	
}
