package fr.campusacademy.tetris.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TetriminosO {
	private Color color;
	
	private Tetriminos bloc1 = new Tetriminos(Color.blue, 50, 50, 100, 0);
	private Tetriminos bloc2 = new Tetriminos(Color.blue, 50, 50, 150, 0);
	private Tetriminos bloc3 = new Tetriminos(Color.blue, 50, 50, 100, 50);
	private Tetriminos bloc4 = new Tetriminos(Color.blue, 50, 50, 150, 50);
	
	public TetriminosO() {
		
	}
	
	public void createItem(Graphics g) {
		bloc1.createItem(g);
		bloc2.createItem(g);
		bloc3.createItem(g);
		bloc4.createItem(g);
	}
}
