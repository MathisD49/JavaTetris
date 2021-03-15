package fr.campusacademy.tetris.game;

<<<<<<< HEAD
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TetriminosJ extends Tetriminos {
//	public int[][] TetriminosJ = { { 0, 0, 6, 0, 0, 0, 6, 0, 0, 6, 6, 0, 0, 0, 0, 0 },
//			{ 0, 0, 0, 0, 0, 6, 6, 6, 0, 0, 0, 6, 0, 0, 0, 0 }, { 0, 6, 6, 0, 0, 6, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0 },
//			{ 0, 0, 0, 0, 0, 6, 0, 0, 0, 6, 6, 6, 0, 0, 0, 0 } };

	private Color color;

	private Tetriminos block1 = new Tetriminos(Color.green, 50, 50, 50, 0);
	private Tetriminos block2 = new Tetriminos(Color.green, 50, 50, 100, 0);
	private Tetriminos block3 = new Tetriminos(Color.green, 50, 50, 150, 0);
	private Tetriminos block4 = new Tetriminos(Color.green, 50, 50, 150, 50);

	public TetriminosJ() {

	}

	public void jCreate(Graphics g) {
		block1.createSquare(g);
		block2.createSquare(g);
		block3.createSquare(g);
		block4.createSquare(g);
	}

	public void goDown(Tetriminos highestBlock) {

	}

	public void goRight() {

	}

	public void goLeft() {

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Tetriminos getBlock1() {
		return block1;
	}

	public void setBlock1(Tetriminos block1) {
		this.block1 = block1;
	}

	public Tetriminos getBlock2() {
		return block2;
	}

	public void setBlock2(Tetriminos block2) {
		this.block2 = block2;
	}

	public Tetriminos getBlock3() {
		return block3;
	}

	public void setBloc3(Tetriminos block3) {
		this.block3 = block3;
	}

	public Tetriminos getBlock4() {
		return block4;
	}

	public void setBlock4(Tetriminos block4) {
		this.block4 = block4;
	}

	@Override
	public String toString() {
		return "Tetriminos J [color=" + color + ", block1=" + block1 + ", block2=" + block2 + ", block3=" + block3
				+ ", block4=" + block4 + "]";
	}
=======
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
>>>>>>> 2c71816924cf3e942c19f98e8dce064fbb34d5a3
}


