package com.mattiasfridsen.thagaem.entity.mob;

import com.mattiasfridsen.thagaem.graphics.Screen;
import com.mattiasfridsen.thagaem.graphics.Sprite;
import com.mattiasfridsen.thagaem.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	
	public Player(Keyboard input) {
		this.input = input;
	}
	
	public Player(int x, int y, Keyboard input) {
		this.x 		= x;
		this.y 		= y;
		this.input 	= input;
	}

	public void update() {
		int dx = 0;
		int dy = 0;
		if (input.up) 		{ dy--; }
		if (input.down) 	{ dy++; }
		if (input.left) 	{ dx--; }
		if (input.right) 	{ dx++; }
		
		if (dx != 0 || dy != 0) { move(dx, dy); }
	}
	
	public void render(Screen screen) {
    		int xx = x - 16;
    		int yy = y - 16;
    		screen.renderPlayer(xx, yy, Sprite.player0);
    		screen.renderPlayer(xx + 16, yy, Sprite.player1);
    		screen.renderPlayer(xx, yy + 16, Sprite.player2);
    		screen.renderPlayer(xx + 16, yy + 16, Sprite.player3);
	}
}
