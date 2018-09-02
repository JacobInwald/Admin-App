package adminapp.ui;

import java.awt.image.BufferedImage;

import adminapp.member.Member;

public class ListButtons extends UIButton {
	
	private Member member;

	public ListButtons(float x, float y, int width, int height, BufferedImage[] image, String name, int age, String DofB, int id, ClickListener clicker) {
				super(x, y, width, height, image, clicker);
				member = new Member(name, age, DofB, id);
		}

}
