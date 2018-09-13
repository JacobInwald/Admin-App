package adminapp.ui.pages;

import java.awt.Graphics;
import java.sql.SQLException;
import java.util.ArrayList;

import adminapp.Handler;
import adminapp.gfx.Assets;
import adminapp.member.Member;
import adminapp.ui.ClickListener;
import adminapp.ui.Page;
import adminapp.ui.UIButton;
import adminapp.ui.UIManager;
import adminapp.ui.UIMemberSearchBox;
import adminapp.utils.Utils;
import database.JDBCDatabaseEditor;

public class UserPage extends Page{
	
	private UIMemberSearchBox searchBox;
	private UIManager uiManager;
	private UIButton findButton, createButton, deleteButton, backButton, membersButton;
	private ArrayList<Member> members;
	
	private String data;
	private String[] dataArray;
	
	public UserPage(Handler handler) {
		super(handler);	
		uiManager = new UIManager();
		members = new ArrayList<Member>();
	
		searchBox = new UIMemberSearchBox(400, 200, 168, 128, "Member Name", handler, false);
		findButton = new UIButton(20, 50, 128, 128, Assets.memberFindButton, new ClickListener(){
			
			public void onClick() {
				if(	searchBox.getMember(members) != null) {
					((MemberPage) handler.getApp().getMemberPage()).setMember(searchBox.getMember(members));
					Page.setCurrentPage(handler.getApp().getMemberPage());
					}
			}
			
		});
		
		createButton = new UIButton(20, 178, 128, 128, Assets.memberCreateButton, new ClickListener(){
			
			public void onClick() {
				Page.setCurrentPage(handler.getApp().getCreateMemberPage());
			}
			
		});
		
		deleteButton = new UIButton(20, 316, 128, 128, Assets.memberDeleteButton, new ClickListener(){
			
			public void onClick() {
				members.remove(searchBox.getMember(members));
				try {
					JDBCDatabaseEditor.deleteFromTable("Member", searchBox.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		backButton = new UIButton(500, 100, 128, 128, Assets.backButton, new ClickListener() {

			@Override
			public void onClick() {
				Page.setCurrentPage(handler.getApp().getLoginPage());				
			}
			
			
			
		});
		
		membersButton = new UIButton(300, 400, 128, 128, Assets.loginButton, new ClickListener() {

			@Override
			public void onClick() {
				Page.setCurrentPage(handler.getApp().getMemberListPage());				
			}
			
		});
		
		
		uiManager.addObject(searchBox);
		uiManager.addObject(findButton);
		uiManager.addObject(deleteButton);
		uiManager.addObject(createButton);
		uiManager.addObject(backButton);
		uiManager.addObject(membersButton);
	}
	
	@Override
	public void init() {
		try {
			data = JDBCDatabaseEditor.getTable("Member");		
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataArray = data.split(" ");
		
		for(int i = 3; i < dataArray.length; i += 4) {

				members.add(new Member(dataArray[i - 3], dataArray[i - 2], Utils.parseInt(dataArray[i - 1]), dataArray[i]));
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
		
	}

	public ArrayList<Member> getMembers() {
		return members;
	}


}
