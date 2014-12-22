package com.mattiasfridsen.thagaem.graphics;

public class Sprite {

	public final int     SIZE;
	private int          x;
	private int          y;
	public int[]         pixels;
	private SpriteSheet  sheet;

	public static Sprite grass      = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower		= new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock		= new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x1639FF);
	
	public static Sprite player_u	= new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite player_d	= new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite player_s	= new Sprite(32, 1, 5, SpriteSheet.tiles);
	
	public static Sprite player_u_1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite player_u_2 = new Sprite(32, 0, 7, SpriteSheet.tiles);
	
	public static Sprite player_d_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite player_d_2 = new Sprite(32, 2, 7, SpriteSheet.tiles);
	
	public static Sprite player_s_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite player_s_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);

	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		pixels = new int[SIZE * SIZE];
		load();
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y)
				        * sheet.SIZE];
			}
		}
	}

	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = colour;
		}
	}
}
