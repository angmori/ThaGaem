package com.mattiasfridsen.thagaem.entity.mob;

import com.mattiasfridsen.thagaem.entity.Entity;
import com.mattiasfridsen.thagaem.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite 	sprite;
	protected int 		dir 	= 0;
	protected boolean 	moving 	= false;
	
	public void move(int dx, int dy) {
		
		if (dx > 0) { dir = 1; }
		if (dx < 0) { dir = 3; }
		if (dy > 0) { dir = 2; }
		if (dy < 0) { dir = 0; }
		// -1, 0, 1
		if(!collision()) {
			x += dx;
			y += dy;
		}
	}
	
	public void update() {
	}
	
	public void render() {
	}
	
	private boolean collision() {
		return false;
	}
}
