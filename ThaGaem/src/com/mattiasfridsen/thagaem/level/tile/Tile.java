package com.mattiasfridsen.thagaem.level.tile;

import com.mattiasfridsen.thagaem.graphics.Screen;
import com.mattiasfridsen.thagaem.graphics.Sprite;

public class Tile {
	
	public int x;
	public int y;
	public Sprite sprite;
	
	public static Tile grass 	= new GrassTile(Sprite.grass);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {		
	}
	
	public boolean solid() {
		return false;
	}
}
