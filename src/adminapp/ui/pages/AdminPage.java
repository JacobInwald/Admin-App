package adminapp.ui.pages;

import java.awt.Graphics;
import java.sql.SQLException;
import java.util.ArrayList;

import adminapp.Handler;
import adminapp.gfx.Assets;
import adminapp.member.Member;
import adminapp.member.User;
import adminapp.ui.ClickListener;
import adminapp.ui.Page;
import adminapp.ui.UIButton;
import adminapp.ui.UIManager;
import adminapp.ui.UIUserSearchBox;
import adminapp.utils.Utils;
import database.JDBCDatabaseEditor;

public class AdminPage extends Page	{
	
	private UIUserSearchBox searchBox;
	private UIManager uiManager;
	private UIButton findButton, createButton, deleteButton, backButton;
	private ArrayList<User> users;
	private String data;
	private String[] dataArray;
	private User user;

public AdminPage(Handler handler) {
	super(handler);	
	uiManager = new UIManager();
	users = new ArrayList<User>();

	searchBox = new UIUserSearchBox(400, 200, 168, 128, "User Name", handler, false);
	findButton = new UIButton(20, 50, 128, 128, Assets.memberFindButton, new ClickListener(){
		
		public void onClick() {
			if(searchBox.getUser(users) != null) {
			handler.getMouseManager().setUiManager(null);
			Page.setCurrentPage(handler.getApp().getUserInfoPage());
			((UserInfoPage) handler.getApp().getUserInfoPage()).setValues(searchBox.getUser(users).getFirstName(), searchBox.getUser(users).getLastName(), searchBox.getUser(users).getPassword());
			}
		}
		
	});
	
	createButton = new UIButton(20, 178, 128, 128, Assets.memberCreateButton, new ClickListener(){
		
		public void onClick() {
			Page.setCurrentPage(handler.getApp().getCreateUserPage());
		}
		
	});
	
	deleteButton = new UIButton(20, 316, 128, 128, Assets.memberDeleteButton, new ClickListener(){
		
		public void onClick() {
			users.remove(searchBox.getUser(users));
			try {
			JDBCDatabaseEditor.deleteFromTable("Employee", searchBox.getText());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	});
	
	backButton = new UIButton(600, 20, 128, 128, Assets.backButton, new ClickListener() {

		@Override
		public void onClick() {
			Page.setCurrentPage(handler.getApp().getLoginPage());				
		}
		
		
		
	});
	
	
	uiManager.addObject(searchBox);
	uiManager.addObject(findButton);
	uiManager.addObject(deleteButton);
	uiManager.addObject(createButton);
	uiManager.addObject(backButton);
}

@Override
public void init() {
	try {
		data = JDBCDatabaseEditor.getUserTable();		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	dataArray = data.split(" ");
	
	for(int i = 2; i < dataArray.length; i += 3) {

			users.add(new User(dataArray[i - 2], dataArray[i - 1], dataArray[i]));
	}}

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
	
}

public ArrayList<User> getUsers() {
	return users;
}


}