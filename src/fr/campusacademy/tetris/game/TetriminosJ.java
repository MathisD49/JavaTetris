package fr.campusacademy.tetris.game;

<<<<<<< HEAD
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TetriminosJ {
	private Color color;
	
	private Tetriminos bloc1 = new Tetriminos(Color.blue, 50, 50, 100, 50);
	private Tetriminos bloc2 = new Tetriminos(Color.blue, 50, 50, 150, 50);
	private Tetriminos bloc3 = new Tetriminos(Color.blue, 50, 50, 200, 50);
	private Tetriminos bloc4 = new Tetriminos(Color.blue, 50, 50, 200, 0);
	
	public TetriminosJ() {
		
	}
	
	public void createItem(Graphics g) {
		bloc1.createItem(g);
		bloc2.createItem(g);
		bloc3.createItem(g);
		bloc4.createItem(g);
	}
=======
public class TetriminosJ {
	public int[][] TetriminosJ = {
			{0,0,6,0,0,0,6,0,0,6,6,0,0,0,0,0},
			{0,0,0,0,0,6,6,6,0,0,0,6,0,0,0,0},
			{0,6,6,0,0,6,0,0,0,6,0,0,0,0,0,0},
			{0,0,0,0,0,6,0,0,0,6,6,6,0,0,0,0}
			};
>>>>>>> bfc53da067c587fc0549395a41dfed8e13e1b6a4
}


