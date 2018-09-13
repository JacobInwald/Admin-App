package adminapp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import adminapp.gfx.Assets;
import adminapp.gfx.Display;
import adminapp.input.KeyManager;
import adminapp.input.MouseManager;
import adminapp.member.Member;
import adminapp.ui.Page;
import adminapp.ui.pages.AdminPage;
import adminapp.ui.pages.CreateMemberPage;
import adminapp.ui.pages.CreateUserPage;
import adminapp.ui.pages.LoginPage;
import adminapp.ui.pages.MemberListPage;
import adminapp.ui.pages.MemberPage;
import adminapp.ui.pages.UserInfoPage;
import adminapp.ui.pages.UserPage;

public class App implements Runnable{
	
	private int width, height;
	private Thread thread;
	private boolean running = false;
	private String title;
	
	private Graphics g;
	private BufferStrategy bs;
	private Display display;
	
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	private Page loginPage;
	private Page userPage;
	private Page memberPage;
	private Page createMemberPage;
	private Page adminPage;
	private Page userInfoPage;
	private Page createUserPage;
	private Page memberListPage;
	
	private Handler handler;
	
	public App(int width, int height, String title) {
		this.height = height;
		this.width = width;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();

	}
	
	private void init() {
		Assets.init();
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		handler = new Handler(this);
		
		adminPage = new AdminPage(handler);
		adminPage.init();
		loginPage = new LoginPage(handler);
		loginPage.init();
		userPage = new UserPage(handler);
		userPage.init();
		memberPage = new MemberPage(handler, new Member("", "", 1, ""));
		memberPage.init();
		createMemberPage = new CreateMemberPage(handler);
		createMemberPage.init();
		userInfoPage = new UserInfoPage(handler);
		userInfoPage.init();
		createUserPage = new CreateUserPage(handler);
		createUserPage.init();
	//	memberListPage = new MemberListPage(handler);
	//	memberListPage.init();
	
		Page.setCurrentPage(loginPage);
	}
	
	private void tick() {
		keyManager.tick();
		if(Page.getCurrentPage() != null) 
			Page.getCurrentPage().tick();		

	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		if(Page.getCurrentPage() != null) 
			Page.getCurrentPage().render(g);
	
		bs.show();
		g.dispose();
	}
	
	
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now -lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				delta--;
			}
		
			if(timer >= 1000000000)
				timer = 0L;
		}
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public Page getLoginPage() {
		return loginPage;
	}

	public Page getUserPage() {
		return userPage;
	}

	public Page getMemberPage() {
		return memberPage;
	}

	public Page getCreateMemberPage() {
		return createMemberPage;
	}

	public Page getAdminPage() {
		return adminPage;
	}

	public Page getUserInfoPage() {
		return userInfoPage;
	}

	public Page getCreateUserPage() {
		return createUserPage;
		}

	public Page getMemberListPage() {
		return memberListPage;
	}

	
	
	
}
