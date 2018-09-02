package adminapp.ui;

import java.awt.Graphics;

import adminapp.Handler;

public abstract class Page {

	public static Page currentPage;
	
	protected UIManager uiManager;
	
	protected Handler handler;
	
	public Page(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void init();
	
	public abstract void tick();
	
	public abstract void render(Graphics g); 
	
	public abstract void changePage();
	
	
	
	public UIManager getUiManager() {
		return uiManager;
	}

	public static void setCurrentPage(Page page) {
		currentPage = page;
	}
	
	public static Page getCurrentPage() {
		return currentPage;
	}
}
