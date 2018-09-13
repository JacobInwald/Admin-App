package adminapp.ui.pages;

import java.awt.Graphics;
import java.sql.SQLException;

import adminapp.Handler;
import adminapp.gfx.Assets;
import adminapp.member.Member;
import adminapp.ui.ClickListener;
import adminapp.ui.Page;
import adminapp.ui.UIButton;
import adminapp.ui.UIManager;
import adminapp.ui.UITextBox;
import adminapp.utils.Utils;
import database.JDBCDatabaseEditor;

public class CreateMemberPage extends Page {

	private UIManager uiManager;
	
	private UITextBox nameBox, secondNameBox, ageBox, DofBBox;
	
	private UIButton createMember, backButton;
	
	public CreateMemberPage(Handler handler) {
		super(handler);
		uiManager = new UIManager();
		
		nameBox = new UITextBox(100, 100, 128, 128, "Name", handler, false);
		ageBox = new UITextBox(228, 100, 128, 128, "Age", handler, false);
		DofBBox = new UITextBox(100, 228, 128, 128, "DofB", handler, false);
		secondNameBox = new UITextBox(356, 228, 128, 128, "Second Name", handler, false);
		
		createMember = new UIButton(500, 100, 128, 128, Assets.memberCreateButton, new ClickListener() {

			@Override
			public void onClick() {
				try {
					createNewMember(nameBox.getText(), secondNameBox.getText(), DofBBox.getText(), Utils.parseInt(ageBox.getText()));
					JDBCDatabaseEditor.insertRecordIntoMemberTable(nameBox.getText(), secondNameBox.getText(), DofBBox.getText(), Utils.parseInt(ageBox.getText()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		backButton = new UIButton(500, 200, 256, 256, Assets.backButton, new ClickListener(){

			@Override
			public void onClick() {
				Page.setCurrentPage(handler.getApp().getUserPage());
			}
			
			
		});

		uiManager.addObject(DofBBox);
		uiManager.addObject(ageBox);
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
	
	public void createNewMember(String name, String secondName, String DofB, int age) {
		((UserPage) handler.getApp().getUserPage()).getMembers().add(new Member(name, secondName, age, DofB));
	}

}
