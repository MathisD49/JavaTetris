package fr.campusacademy.tetris.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class LineTetriminos extends Tetriminos {
	
	private Color color;
	private boolean isVertical = false;
	
	private Tetriminos bloc1 = new Tetriminos(Color.red, 50, 50, 100, 0);
	private Tetriminos bloc2 = new Tetriminos(Color.blue, 50, 50, 150, 0);
	private Tetriminos bloc3 = new Tetriminos(Color.pink, 50, 50, 200, 0);
	private Tetriminos bloc4 = new Tetriminos(Color.green, 50, 50, 250, 0);
	
	public LineTetriminos() {
		
	}
	
	public void createItem(Graphics g) {
		bloc1.createItem(g);
		bloc2.createItem(g);
		bloc3.createItem(g);
		bloc4.createItem(g);
	}
	
	public void goDown() {
		bloc1.setY(bloc1.getY() + 50);
		bloc2.setY(bloc2.getY() + 50);
		bloc3.setY(bloc3.getY() + 50);
		bloc4.setY(bloc4.getY() + 50);
	}
	
	public void goRight() {
		bloc1.setX(bloc1.getX() + 50);
		bloc2.setX(bloc2.getX() + 50);
		bloc3.setX(bloc3.getX() + 50);
		bloc4.setX(bloc4.getX() + 50);
	}
	
	public void goLeft() {
		bloc1.setX(bloc1.getX() - 50);
		bloc2.setX(bloc2.getX() - 50);
		bloc3.setX(bloc3.getX() - 50);
		bloc4.setX(bloc4.getX() - 50);
	}
	
	public void rotateRight(boolean vertical) {
		if(vertical) {
			bloc1.setX(bloc1.getX() - 150);
			bloc1.setY(bloc1.getY() + 150);
			
			bloc2.setX(bloc2.getX() - 100);
			bloc2.setY(bloc2.getY() + 100);
			
			bloc3.setX(bloc3.getX() - 50);
			bloc3.setY(bloc3.getY() + 50);
			
			this.setVertical(false);
			
		} else {
			bloc1.setX(bloc1.getX() + 150);
			bloc1.setY(bloc1.getY() - 150);
			
			bloc2.setX(bloc2.getX() + 100);
			bloc2.setY(bloc2.getY() - 100);
			
			bloc3.setX(bloc3.getX() + 50);
			bloc3.setY(bloc3.getY() - 50);
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

	public Tetriminos getBloc1() {
		return bloc1;
	}

	public void setBloc1(Tetriminos bloc1) {
		this.bloc1 = bloc1;
	}

	public Tetriminos getBloc2() {
		return bloc2;
	}

	public void setBloc2(Tetriminos bloc2) {
		this.bloc2 = bloc2;
	}

	public Tetriminos getBloc3() {
		return bloc3;
	}

	public void setBloc3(Tetriminos bloc3) {
		this.bloc3 = bloc3;
	}

	public Tetriminos getBloc4() {
		return bloc4;
	}

	public void setBloc4(Tetriminos bloc4) {
		this.bloc4 = bloc4;
	}

	public boolean isVertical() {
		return isVertical;
	}

	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}

	@Override
	public String toString() {
		return "LineTetriminos [color=" + color + ", bloc1=" + bloc1 + ", bloc2=" + bloc2 + ", bloc3=" + bloc3
				+ ", bloc4=" + bloc4 + "]";
	}
	
	
	
	
}
