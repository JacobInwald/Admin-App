package adminapp.ui.pages;

import java.awt.Graphics;

import adminapp.Handler;
import adminapp.member.Member;
import adminapp.ui.Page;

public class MemberPage extends Page {

	private Member member;
	
	public MemberPage(Handler handler, Member member) {
		super(handler);
		this.member = member;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tick() {
		handler.getMouseManager().setUiManager(uiManager);
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

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
	}

	
	
}

