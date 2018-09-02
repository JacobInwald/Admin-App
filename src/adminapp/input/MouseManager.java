package adminapp.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import adminapp.ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener{

	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		if(e.getButton() == MouseEvent.BUTTON2)
			rightPressed = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		if(e.getButton() == MouseEvent.BUTTON2)
			rightPressed = false;
		if(getUiManager() != null)
			getUiManager().onMouseRelease(e);
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if(getUiManager() != null)
			getUiManager().onMouseMove(e);
		
	}
	
	
	
	public void setUiManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}

	public boolean isLeftPressed() {
		return leftPressed;
	}

	public boolean isRightPressed() {
		return rightPressed;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public UIManager getUiManager() {
		return uiManager;
	}



	
	
}
