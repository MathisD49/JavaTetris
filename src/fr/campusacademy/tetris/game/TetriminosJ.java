package fr.campusacademy.tetris.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TetriminosJ extends Tetriminos{
	private Color color;
	
	private Tetriminos block1 = new Tetriminos(Color.blue, 50, 50, 100, 50);
	private Tetriminos block2 = new Tetriminos(Color.blue, 50, 50, 150, 50);
	private Tetriminos block3 = new Tetriminos(Color.blue, 50, 50, 200, 50);
	private Tetriminos block4 = new Tetriminos(Color.blue, 50, 50, 200, 0);
	
	public TetriminosJ() {
		
	}
	
	public void createItem(Graphics g) {
		block1.createItem(g);
		block2.createItem(g);
		block3.createItem(g);
		block4.createItem(g);
	}
}


