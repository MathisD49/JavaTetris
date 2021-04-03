package fr.campusacademy.tetris.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TetriminosI extends Tetriminos {
	
	private Color color;
	private boolean isVertical = false;
	
	private Tetriminos block1 = new Tetriminos(Color.red, 50, 50, 100, 0);
	private Tetriminos block2 = new Tetriminos(Color.blue, 50, 50, 150, 0);
	private Tetriminos block3 = new Tetriminos(Color.pink, 50, 50, 200, 0);
	private Tetriminos block4 = new Tetriminos(Color.green, 50, 50, 250, 0);
	
	public TetriminosI() {
		
	}
	
	public void createItem(Graphics g) {
		block1.createItem(g);
		block2.createItem(g);
		block3.createItem(g);
		block4.createItem(g);
	}
	
	public void goDown() {
		block1.setY(block1.getY() + 50);
		block2.setY(block2.getY() + 50);
		block3.setY(block3.getY() + 50);
		block4.setY(block4.getY() + 50);
	}
	
	public void goRight() {
		block1.setX(block1.getX() + 50);
		block2.setX(block2.getX() + 50);
		block3.setX(block3.getX() + 50);
		block4.setX(block4.getX() + 50);
	}
	
	public void goLeft() {
		block1.setX(block1.getX() - 50);
		block2.setX(block2.getX() - 50);
		block3.setX(block3.getX() - 50);
		block4.setX(block4.getX() - 50);
	}
	
	public void rotateRight(boolean vertical) {
		if(vertical) {
			block1.setX(block1.getX() - 150);
			block1.setY(block1.getY() + 150);
			
			block2.setX(block2.getX() - 100);
			block2.setY(block2.getY() + 100);
			
			block3.setX(block3.getX() - 50);
			block3.setY(block3.getY() + 50);
			
			this.setVertical(false);
			
		} else {
			block1.setX(block1.getX() + 150);
			block1.setY(block1.getY() - 150);
			
			block2.setX(block2.getX() + 100);
			block2.setY(block2.getY() - 100);
			
			block3.setX(block3.getX() + 50);
			block3.setY(block3.getY() - 50);
			this.setVertical(true);
		}
		
	}
	
	public void rotateLeft(boolean vertical) {
		this.rotateRight(vertical);
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

	public void setBloc1(Tetriminos block1) {
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

	public void setBlock3(Tetriminos block3) {
		this.block3 = block3;
	}

	public Tetriminos getBlock4() {
		return block4;
	}

	public void setBlock4(Tetriminos block4) {
		this.block4 = block4;
	}

	public boolean isVertical() {
		return isVertical;
	}

	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}

	@Override
	public String toString() {
		return "LineTetriminos [color=" + color + ", block1=" + block1 + ", block2=" + block2 + ", block3=" + block3
				+ ", block4=" + block4 + "]";
	}	
}
