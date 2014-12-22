package com.mattiasfridsen.thagaem.entity.mob;

import com.mattiasfridsen.thagaem.graphics.Screen;
import com.mattiasfridsen.thagaem.graphics.Sprite;
import com.mattiasfridsen.thagaem.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard 	input;
	private Sprite	 	sprite;
	private int			anim	= 0;
	private	boolean		walking = false;
	
	public Player(Keyboard input) {
		this.input 	= input;
		sprite 		= Sprite.player_u;
	}
	
	public Player(int x, int y, Keyboard input) {
		this.x 		= x;
		this.y 		= y;
		this.input 	= input;
	}

	public void update() {
		int dx = 0;
		int dy = 0;
		
		if (anim < 7500) 	{ anim++; } 
		else				{ anim = 0; }
		
		if (input.up) 		{ dy--; }
		if (input.down) 	{ dy++; }
		if (input.left) 	{ dx--; }
		if (input.right) 	{ dx++; }
		
		if (dx != 0 || dy != 0) {
			move(dx, dy);
			walking = true;
		} else 				{ walking = false; }
	}
	
	public void render(Screen screen) {
		int flip		= 0;
		
		switch (dir) {
		case 0:	sprite 	= Sprite.player_u;
				if (walking) {
					if (anim % 20 > 10) { sprite = Sprite.player_u_1; }
					else 				{ sprite = Sprite.player_u_2 ;}
				}
				break;
				
		case 1: sprite 	= Sprite.player_s;
        		if (walking) {
        			if (anim % 20 > 10) { sprite = Sprite.player_s_1; }
        			else 				{ sprite = Sprite.player_s_2 ;}
        		}
				break;
				
		case 2: sprite 	= Sprite.player_d;
        		if (walking) {
        			if (anim % 20 > 10) { sprite = Sprite.player_d_1; }
        			else 				{ sprite = Sprite.player_d_2 ;}
        		}
				break;
		
		case 3: sprite 	= Sprite.player_s;
        		if (walking) {
        			if (anim % 20 > 10) { sprite = Sprite.player_s_1; }
        			else 				{ sprite = Sprite.player_s_2 ;}
        		}
				flip	= 1;
		}
		
    	screen.renderPlayer(x - (Sprite.player_d.SIZE / 2), 
    			y - (Sprite.player_d.SIZE / 2), sprite, flip);
	}
}
