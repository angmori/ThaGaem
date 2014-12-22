package com.mattiasfridsen.thagaem.graphics;

import java.util.Random;

import com.mattiasfridsen.thagaem.entity.mob.Player;
import com.mattiasfridsen.thagaem.level.tile.Tile;

public class Screen {

	public final int 	MAP_SIZE      = 64;
	public final int 	MAP_SIZE_MASK = MAP_SIZE - 1;
	public int       	width;
	public int       	height;
	public int			xOffset;
	public int 			yOffset;
	public int[]     	pixels;
	public int[]     	tiles  = new int[MAP_SIZE * MAP_SIZE];

	private Random 		random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
			tiles[0] = 0;
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				
				if(xa < -tile.sprite.SIZE || xa >= width 
						|| ya < 0 || ya >= height) { break; }
				if (xa < 0) { xa = 0; }
				
				pixels[xa + ya * width] = tile.sprite.pixels[x + 
				                           y * tile.sprite.SIZE];
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite, int flip) {
		xp -= xOffset;
		yp -= yOffset;
		
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya 	= y + yp;
			int ys 	= y;

			if (flip == 2 || flip == 3) { ys = 31 - y; }
			
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa 	= x + xp;
				int xs 	= x;

				if (flip == 1 || flip == 3) { xs = 31 - x; }
				
				int col = sprite.pixels[xs + ys * sprite.SIZE];
				
				if(xa < -sprite.SIZE || xa >= width 
						|| ya < 0 || ya >= height) { break; }
				if (xa < 0) { xa = 0; }
				
				//System.out.println(col);
				/* Used to check what the value of the color pink (255, 0, 255 
				 * in RGB) is. It should be hex 0xFFFF00FF, or dec 4294902015, 
				 * but is instead hex C1FF00FF or dec -1040252673. This
				 * is easy to find out, since the first pixel to be drawn will
				 * be pink, and thus the first value printed will represent it.
				 */
				if (col != 0xC1FF00FF) pixels[xa + ya * width] = col;
				
				//System.out.println(Sprite.player_d.SIZE);
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
