package fr.campusacademy.tetris.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

// class pour les blocs de chaque pièces
public class Tetriminos {
	
	private Color color;
	private int height;
	private int width;
	private int x;
	private int y;
	private boolean isMovable;
	
	public Tetriminos() {
		
	}
	
	public Tetriminos(Color color, int height, int width, int x, int y) {
		this.color = color;
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		this.setMovable(true);
	}
	
	public void createItem(Graphics g) {
		g.setColor(this.color); //set la couleur pour notre carré
		g.fillRect(this.x, this.y, this.width, this.height); // dessine un carré et le remplie avec la couleur d'au dessus
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

	public boolean isMovable() {
		return isMovable;
	}

	public void setMovable(boolean isMovable) {
		this.isMovable = isMovable;
	}

	@Override
	public String toString() {
		return "Tetriminos [color=" + color + ", height=" + height + ", width=" + width + ", x=" + x + ", y=" + y
				+ ", isMovable=" + isMovable + "]";
	}
	
}
