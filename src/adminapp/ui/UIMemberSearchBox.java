package adminapp.ui;

import java.util.ArrayList;

import adminapp.Handler;
import adminapp.member.Member;

public class UIMemberSearchBox extends UITextBox{

	
	public UIMemberSearchBox(float x, float y, int width, int height, String name, Handler handler, boolean concealed) {
		super(x, y, width, height, name, handler, concealed);
	}
	
	public Member getMember(ArrayList<Member> members) {
		for(Member otherMember : members) {
			if(otherMember.getName().equals(getText()))
				return otherMember;
			
		}
		return null;
	}



}