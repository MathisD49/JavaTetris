package fr.campusacademy.tetris.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TetriminosL extends Tetriminos {
//	public int[][] TetriminosL = { { 0, 7, 0, 0, 0, 7, 0, 0, 0, 7, 7, 0, 0, 0, 0, 0 },
//			{ 0, 0, 0, 0, 0, 0, 0, 7, 0, 7, 7, 7, 0, 0, 0, 0 }, { 0, 7, 7, 0, 0, 0, 7, 0, 0, 0, 7, 0, 0, 0, 0, 0 },
//			{ 0, 0, 0, 0, 0, 7, 7, 7, 0, 7, 0, 0, 0, 0, 0, 0 } };

	private Color color;

	private Tetriminos block1 = new Tetriminos(Color.green, 50, 50, 50, 0);
	private Tetriminos block2 = new Tetriminos(Color.green, 50, 50, 100, 0);
	private Tetriminos block3 = new Tetriminos(Color.green, 50, 50, 150, 0);
	private Tetriminos block4 = new Tetriminos(Color.green, 50, 50, 200, 0);
	private Tetriminos block5 = new Tetriminos(Color.green, 50, 50, 200, 0);

	public TetriminosL() {

	}

	public void lCreate(Graphics g) {
		block1.createSquare(g);
		block2.createSquare(g);
		block3.createSquare(g);
		block4.createSquare(g);
		block5.createSquare(g);
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

	public Tetriminos getBlock5() {
		return block4;
	}

	public void setBlock5(Tetriminos block5) {
		this.block5 = block5;
	}

	@Override
	public String toString() {
		return "Tetriminos L [color=" + color + ", block1=" + block1 + ", block2=" + block2 + ", block3=" + block3
				+ ", block4=" + block4 + ", block5=" + block5 + "]";
	}
}
