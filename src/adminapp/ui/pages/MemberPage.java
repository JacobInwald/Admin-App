package adminapp.ui.pages;

import java.awt.Graphics;

import adminapp.Handler;
import adminapp.gfx.Assets;
import adminapp.member.Member;
import adminapp.ui.ClickListener;
import adminapp.ui.Page;
import adminapp.ui.UIBox;
import adminapp.ui.UIButton;
import adminapp.ui.UIManager;
import adminapp.utils.Utils;

public class MemberPage extends Page {

	private UIManager uiManager;
	private UIBox firstNameBox, DofBBox, AgeBox;
	private UIButton backButton;
	private Member member;
	
	public MemberPage(Handler handler, Member member) {
		super(handler);
		this.member = member;
		uiManager = new UIManager();
		
		firstNameBox = new UIBox( 100, 100, 128, 128, "Name", member.getFirstName());
		DofBBox = new UIBox(100, 200, 136, 128, "DofB", member.getDofB());
		AgeBox = new UIBox(100, 300, 128, 128, "Age", "");
		backButton = new UIButton(600, 50, 256, 256, Assets.backButton, new ClickListener(){

			@Override
			public void onClick() {
				Page.setCurrentPage(handler.getApp().getUserPage());
			}
			
			
		});
		
		uiManager.addObject(firstNameBox);
		uiManager.addObject(DofBBox);
		uiManager.addObject(AgeBox);
		uiManager.addObject(backButton);
	}

	@Override
	public void init() {

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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
		
		firstNameBox.setText(member.getFirstName());
		DofBBox.setText(member.getDofB());
		AgeBox.setText(Utils.parseString(member.getAge()));
	}

	
	
}

