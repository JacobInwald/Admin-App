package adminapp.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys, cantPress, justPressed;
	public boolean Q, W, E, R, T, Y, U, I, O, P, A, S, D, F, G, H,
					J, K, L, Z, X, C, V, B, N, M;
	public boolean BACKSPACE;
	public int lastKeyPress;
	
	public KeyManager() {
		keys = new boolean[256];
		cantPress = new boolean[keys.length];
		justPressed = new boolean[keys.length];
		lastKeyPress = 0;
	}
	
	public void tick() {
		for(int i = 0; i < keys.length; i++) {
			if(cantPress[i] && !keys[i])
				cantPress[i] = false;
			else if(justPressed[i]) {
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i])
				justPressed[i] = true;
		}
		
		
		Q = keys[KeyEvent.VK_Q]; W = keys[KeyEvent.VK_W];
		E = keys[KeyEvent.VK_E]; R = keys[KeyEvent.VK_R];
		T = keys[KeyEvent.VK_T]; Y = keys[KeyEvent.VK_Y];
		U = keys[KeyEvent.VK_U]; I = keys[KeyEvent.VK_I];
		O = keys[KeyEvent.VK_O]; P = keys[KeyEvent.VK_P];
		A = keys[KeyEvent.VK_A]; S = keys[KeyEvent.VK_S]; 
		D = keys[KeyEvent.VK_D]; F = keys[KeyEvent.VK_F];
		G = keys[KeyEvent.VK_G]; H = keys[KeyEvent.VK_H];
		J = keys[KeyEvent.VK_J]; K = keys[KeyEvent.VK_K];
		L = keys[KeyEvent.VK_L]; Z = keys[KeyEvent.VK_Z];
		X = keys[KeyEvent.VK_X]; C = keys[KeyEvent.VK_C];
		V = keys[KeyEvent.VK_V]; B = keys[KeyEvent.VK_B];
		N = keys[KeyEvent.VK_N]; M = keys[KeyEvent.VK_M];
		BACKSPACE = keys[KeyEvent.VK_BACK_SPACE];
		
		
		
	}
	
	
	public boolean keyJustPressed(int keyCode) {
		if(keyCode < 0 || keyCode > 256)
			return false;
		return justPressed[keyCode];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() > 256)
			return;
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

}
