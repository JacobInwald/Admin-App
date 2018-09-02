package adminapp.ui.pages;

import java.awt.Graphics;
import java.util.ArrayList;

import adminapp.Handler;
import adminapp.gfx.Assets;
import adminapp.member.Member;
import adminapp.ui.ClickListener;
import adminapp.ui.Page;
import adminapp.ui.UIButton;
import adminapp.ui.UIManager;
import adminapp.ui.UIMemberSearchBox;

public class UserPage extends Page{
	
	private UIMemberSearchBox searchBox;
	private UIManager uiManager;
	private UIButton findButton, createButton, deleteButton;
	private ArrayList<Member> members;
	
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
				//searchBox.getMember(members);
			}
			
		});
		
		deleteButton = new UIButton(20, 316, 128, 128, Assets.memberDeleteButton, new ClickListener(){
			
			public void onClick() {
				//searchBox.getMember(members);
			}
			
		});
		
		
		uiManager.addObject(searchBox);
		uiManager.addObject(findButton);
		uiManager.addObject(deleteButton);
		uiManager.addObject(createButton);
	}
	
	@Override
	public void init() {
		members.add(new Member("ethan", 15, "21/12/2002", 0));

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


}
