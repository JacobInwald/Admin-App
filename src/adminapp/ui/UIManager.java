package adminapp.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {
	private ArrayList<UIObject> objects;
	
	public UIManager() {
		objects = new ArrayList<UIObject>();
	}
	
	public void render(Graphics g) {
		for(UIObject o: objects) {
			o.render(g);
		}
	}
	
	public void tick() {
		for(UIObject o: objects) {
			o.tick();
		}
	}
	
	public void onMouseMove(MouseEvent e){
		for(UIObject o: objects) {
			o.onMouseMove(e);
		} 
	}
	
	public void onMouseRelease(MouseEvent e) {
		for(UIObject o : objects) {
			o.onMouseRelease(e);
		}
	}
	
	public void addObject(UIObject o) {
		objects.add(o);
	}
	
	public void removeObject(UIObject o) {
		objects.remove(o);
	}

	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}
	
	
}
