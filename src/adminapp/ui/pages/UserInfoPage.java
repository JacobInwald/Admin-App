package adminapp.ui.pages;

import java.awt.Graphics;

import adminapp.Handler;
import adminapp.gfx.Assets;
import adminapp.ui.ClickListener;
import adminapp.ui.Page;
import adminapp.ui.UIBox;
import adminapp.ui.UIButton;
import adminapp.ui.UIManager;

public class UserInfoPage extends Page {

	private UIManager uiManager;
	private UIBox firstNameBox, lastNameBox, passwordBox;
	private UIButton backButton;
	
	public UserInfoPage(Handler handler) {
		super(handler);
		 uiManager= new UIManager();
		 
		 firstNameBox = new UIBox(20, 20, 128, 128, "first name", "");
		 lastNameBox = new UIBox(20, 148, 128, 128, "last name", "");
		 passwordBox = new UIBox(20, 276, 128, 128, "password", "");

		 backButton = new UIButton(500, 20, 128, 128, Assets.backButton, new ClickListener() {

			@Override
			public void onClick() {
				Page.setCurrentPage(handler.getApp().getAdminPage());
			}
			 
		 });
		 
		 uiManager.addObject(firstNameBox);
		 uiManager.addObject(lastNameBox);
		 uiManager.addObject(passwordBox);
		 uiManager.addObject(backButton);
		 
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		uiManager.tick();
		handler.getMouseManager().setUiManager(uiManager);
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);		
	}

	@Override
	public void changePage() {
		// TODO Auto-generated method stub
		
	}

	public void setValues(String firstName, String lastName, String password) {
		firstNameBox.setText(firstName);
		lastNameBox.setText(lastName);
		passwordBox.setText(password);
	}
	}

