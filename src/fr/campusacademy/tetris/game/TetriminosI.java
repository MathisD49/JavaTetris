package fr.campusacademy.tetris.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TetriminosI extends Tetriminos {
//	public int[][] TetriminosI = { { 0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0 },
//			{ 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0 },
//			{ 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

	private Color color;

	private Tetriminos block1 = new Tetriminos(Color.green, 50, 50, 50, 0);
	private Tetriminos block2 = new Tetriminos(Color.green, 50, 50, 100, 0);
	private Tetriminos block3 = new Tetriminos(Color.green, 50, 50, 150, 0);
	private Tetriminos block4 = new Tetriminos(Color.green, 50, 50, 200, 0);

	public TetriminosI() {

	}

	public void iCreate(Graphics g) {
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
		return "Tetriminos I [color=" + color + ", bloc1=" + block1 + ", bloc2=" + block2 + ", bloc3=" + block3
				+ ", bloc4=" + block4 + "]";
	}
}
