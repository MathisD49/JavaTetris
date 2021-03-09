package fr.campusacademy.tetris.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Tetriminos {
	
	private Color color;
	private int height;
	private int width;
	private int x;
	private int y;
	
	public Tetriminos() {
		
	}
	
	public Tetriminos(Color color, int height, int width, int x, int y) {
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
