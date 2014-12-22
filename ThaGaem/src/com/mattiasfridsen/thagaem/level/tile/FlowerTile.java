package com.mattiasfridsen.thagaem.level.tile;

import com.mattiasfridsen.thagaem.graphics.Screen;
import com.mattiasfridsen.thagaem.graphics.Sprite;

public class FlowerTile extends Tile {

	public FlowerTile(Sprite sprite) {
	    super(sprite);
    }
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
