package adminapp.ui.pages;

import java.awt.Graphics;
import java.sql.SQLException;

import adminapp.Handler;
import adminapp.gfx.Assets;
import adminapp.member.User;
import adminapp.ui.ClickListener;
import adminapp.ui.Page;
import adminapp.ui.UIButton;
import adminapp.ui.UIManager;
import adminapp.ui.UITextBox;
import database.JDBCDatabaseEditor;

public class CreateUserPage extends Page {


	private UIManager uiManager;
	
	private UITextBox nameBox, secondNameBox, pwdBox;
	
	private UIButton createMember, backButton;
	
	public CreateUserPage(Handler handler) {
		super(handler);
		uiManager = new UIManager();
		
		nameBox = new UITextBox(100, 100, 128, 128, "First Name", handler, false);
		pwdBox = new UITextBox(228, 100, 128, 128, "Password", handler, false);
		secondNameBox = new UITextBox(100, 228, 128, 128, "Second Name", handler, false);
		
		createMember = new UIButton(500, 100, 128, 128, Assets.memberCreateButton, new ClickListener() {

			@Override
			public void onClick() {
				try {
					createNewUser(nameBox.getText(), secondNameBox.getText(), pwdBox.getText());
					JDBCDatabaseEditor.insertRecordIntoUserTable(nameBox.getText(), secondNameBox.getText(), pwdBox.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		backButton = new UIButton(500, 200, 256, 256, Assets.backButton, new ClickListener(){

			@Override
			public void onClick() {
				Page.setCurrentPage(handler.getApp().getAdminPage());
			}
			
			
		});

		uiManager.addObject(pwdBox);
		uiManager.addObject(nameBox);
		uiManager.addObject(backButton);
		uiManager.addObject(createMember);
		uiManager.addObject(secondNameBox);
		
		}

	@Override
	public void init() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}
	
	public void createNewUser(String name, String secondName, String pwd) {
		((AdminPage) handler.getApp().getAdminPage()).getUsers().add(new User(name, secondName, pwd));
	}

}

