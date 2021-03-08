package fr.campusacademy.tetris.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Tetriminos {
	
	private Color color;
	private int height;
	private int width;
	private int x, y;
	
	public Tetriminos() {
		
	}
	
	public Tetriminos(Color color, int height, int width, int x, int y) {
		super();
		this.color = color;
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
	}
	
	public void createSquare(Graphics g) {
		g.drawRect(this.x, this.y, this.height, this.width);
		g.setColor(this.color);
	}
	
	
}
