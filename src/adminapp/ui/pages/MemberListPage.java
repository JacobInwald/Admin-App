package adminapp.ui.pages;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.SQLException;

import adminapp.Handler;
import adminapp.gfx.Assets;
import adminapp.gfx.Text;
import adminapp.member.User;
import adminapp.ui.Page;
import database.JDBCDatabaseEditor;

public class MemberListPage extends Page {

	private String data;
	private String[] dataArray;
	
	public MemberListPage(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
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
		data = "";
		
		for(int i =3; i < dataArray.length; i += 4) {
			data += dataArray[i - 3];
			data += " ";
			data += dataArray[i - 2];
			data += " ";
			data += dataArray[i - 1];
			data += " ";
			data += dataArray[i];
			data += "\\";
		}
		
		dataArray = data.split("\\");
		data = null;
	}

	@Override
	public void tick() {
		handler.getMouseManager().setUiManager(uiManager);

	}

	@Override
	public void render(Graphics g) {
		for(int i = 0; i < dataArray.length; i++) {
			Text.drawString(g, dataArray[i], 20, i * 32, false, Color.BLACK, Assets.PixelForce20);
		}
	}

	@Override
	public void changePage() {
		// TODO Auto-generated method stub

	}

}
