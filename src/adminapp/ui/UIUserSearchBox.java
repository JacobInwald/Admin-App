package adminapp.ui;

import java.util.ArrayList;

import adminapp.Handler;
import adminapp.member.Member;
import adminapp.member.User;

public class UIUserSearchBox extends UITextBox {

	public UIUserSearchBox(float x, float y, int width, int height, String name, Handler handler, boolean concealed) {
		super(x, y, width, height, name, handler, concealed);
		// TODO Auto-generated constructor stub
	}

	public User getUser(ArrayList<User> users) {
		for(User otherUser : users) {
			if(otherUser.getUserName().equals(getText()))
				return otherUser;
			
		}
		return null;
	}
	

}
