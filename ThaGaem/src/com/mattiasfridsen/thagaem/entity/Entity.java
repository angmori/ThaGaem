package com.mattiasfridsen.thagaem.entity;

import java.util.Random;

import com.mattiasfridsen.thagaem.graphics.Screen;
import com.mattiasfridsen.thagaem.level.Level;

public abstract class Entity {

	public int x;
	public int y;
	
	private boolean removed = false;
	
	protected Level level;
	protected final Random random = new Random();
	
	public void update() {		
	}
	
	public void render(Screen screen) {		
	}
	
	public void remove() {
		//TODO Remove from level.
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
}
