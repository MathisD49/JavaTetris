package fr.campusacademy.tetris.game;

<<<<<<< HEAD
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
=======
public class TetriminosO {
	public int[][] TetriminosO = {
			{0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0},
			{0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0},
			{0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0},
			{0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0}
			};
>>>>>>> bfc53da067c587fc0549395a41dfed8e13e1b6a4
}
