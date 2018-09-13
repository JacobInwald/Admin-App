package adminapp.ui.pages;

import java.awt.Graphics;
import java.util.ArrayList;

import adminapp.Handler;
import adminapp.gfx.Assets;
import adminapp.member.User;
import adminapp.ui.ClickListener;
import adminapp.ui.Page;
import adminapp.ui.UIButton;
import adminapp.ui.UIManager;
import adminapp.ui.UITextBox;

public class LoginPage extends Page{

	private boolean usernameCorrect =false, passwordCorrect = false;
	private ArrayList<String> acceptedUsernames;
	private ArrayList<String> acceptedPasswords;

	private UIButton loginButton;
	private UITextBox usernameBox;
	private UITextBox passwordBox;


	public LoginPage(Handler handler) {
		super(handler);
		uiManager = new UIManager();
		acceptedUsernames = new ArrayList<String>();
		acceptedPasswords = new ArrayList<String>();
		usernameBox = new UITextBox(420, 128, 128, 128, "Username", handler, false);
		passwordBox = new UITextBox(420, 256, 128, 128, "Password", handler, true);
		loginButton = new UIButton(420, 384, 128, 128, Assets.loginButton,new ClickListener() {
			
			public void onClick() {
				checkLoginDetails();
			}});
		uiManager.addObject(loginButton);
		uiManager.addObject(usernameBox);
		uiManager.addObject(passwordBox);
	}
	
	@Override
	public void init() {
		for (User user : ((AdminPage) handler.getApp().getAdminPage()).getUsers()) {
			acceptedUsernames.add(user.getUserName());
		}		

		for (User user : ((AdminPage) handler.getApp().getAdminPage()).getUsers()) {
			acceptedPasswords.add(user.getPassword());
		}
		
	}

	@Override
	public void tick() {
		handler.getMouseManager().setUiManager(uiManager);	
		uiManager.tick();		
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

	@Override
	public void changePage() {
		checkLoginDetails();
		
	}

	public void checkLoginDetails(){
		for(String username2 : acceptedUsernames) {	
			if(username2.equals(usernameBox.getText())) {
				usernameCorrect = true;
			}else{
				System.out.println("Username not accepted!");
			}
		}
		for(String password2: acceptedPasswords) {
			if(password2.equals(passwordBox.getText())) {
				passwordCorrect = true;
			}
			else {
				System.out.println("Password not accepted!");
			}
		}
		 
		if(passwordBox.getText().equals("1234") && usernameBox.getText().equals("bob")) {
			Page.setCurrentPage(handler.getApp().getAdminPage());
		}
		
		if(passwordCorrect && !usernameCorrect)
			passwordCorrect = false;
		if(!passwordCorrect && usernameCorrect)
			usernameCorrect = false;
		if(passwordCorrect && usernameCorrect) {
			Page.setCurrentPage(handler.getApp().getUserPage());
			handler.getMouseManager().setUiManager(handler.getApp().getUserPage().getUiManager());
			usernameCorrect = false;
			passwordCorrect = false;
			}
	}

	public ArrayList<String> getAcceptedUsernames() {
		return acceptedUsernames;
	}

	public ArrayList<String> getAcceptedPasswords() {
		return acceptedPasswords;
	}





}
