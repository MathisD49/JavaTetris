package fr.campusacademy.tetris.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TetriminosL extends Tetriminos{
	private Color color;
	
	private boolean isMovable = true;
	
	private int indexRotate = 1;
	
	private Tetriminos bloc1 = new Tetriminos(Color.blue, 50, 50, 200, 50);
	private Tetriminos bloc2 = new Tetriminos(Color.blue, 50, 50, 150, 50);
	private Tetriminos bloc3 = new Tetriminos(Color.blue, 50, 50, 100, 50);
	private Tetriminos bloc4 = new Tetriminos(Color.blue, 50, 50, 100, 0);
	
	public TetriminosL() {
		
	}
	
	public TetriminosL(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		bloc1 = new Tetriminos(Color.blue, 50, 50, x1, y1);
		bloc2 = new Tetriminos(Color.blue, 50, 50, x2, y2);
		bloc3 = new Tetriminos(Color.blue, 50, 50, x3, y3);
		bloc4 = new Tetriminos(Color.blue, 50, 50, x4, y4);
	}
	
	public void createItem(Graphics g) {
		bloc1.createItem(g);
		bloc2.createItem(g);
		bloc3.createItem(g);
		bloc4.createItem(g);
	}
	
	// permet de faire déscendre la pièce
	public void goDown() {
		bloc1.setY(bloc1.getY() + 50);
		bloc2.setY(bloc2.getY() + 50);
		bloc3.setY(bloc3.getY() + 50);
		bloc4.setY(bloc4.getY() + 50);
	}
	
	// permet de déplacer la pièce à droite
	public void goRight() {
		bloc1.setX(bloc1.getX() + 50);
		bloc2.setX(bloc2.getX() + 50);
		bloc3.setX(bloc3.getX() + 50);
		bloc4.setX(bloc4.getX() + 50);
	}
	
	// permet de déplacer la pièce à gauche
	public void goLeft() {
		bloc1.setX(bloc1.getX() - 50);
		bloc2.setX(bloc2.getX() - 50);
		bloc3.setX(bloc3.getX() - 50);
		bloc4.setX(bloc4.getX() - 50);
	}
	
	// permet de tourner la pièce à droite
	public void rotateRight(int position) {			
		if(position == 1) {
			
			bloc1.setX(bloc1.getX() - 50);
			bloc1.setY(bloc1.getY() + 50);
			
			bloc3.setX(bloc3.getX() + 50);
			bloc3.setY(bloc3.getY() - 50);
			
			bloc4.setX(bloc4.getX() + 100);
			
			this.setIndexRotate(2);
			
			
			
		} else if (position == 2) {
			
			bloc1.setX(bloc1.getX() - 50);
			bloc1.setY(bloc1.getY() - 50);
			
			bloc3.setX(bloc3.getX() + 50);
			bloc3.setY(bloc3.getY() + 50);
			
			bloc4.setY(bloc4.getY() + 100);
			
			this.setIndexRotate(3);
			
		} else if (position == 3) {
			
			bloc1.setX(bloc1.getX() + 50);
			bloc1.setY(bloc1.getY() - 50);
			
			bloc3.setX(bloc3.getX() - 50);
			bloc3.setY(bloc3.getY() + 50);
			
			bloc4.setX(bloc4.getX() - 100);
			
			this.setIndexRotate(4);
			
		} else if (position == 4) {
			
			bloc1.setX(bloc1.getX() + 50);
			bloc1.setY(bloc1.getY() + 50);
			
			bloc3.setX(bloc3.getX() - 50);
			bloc3.setY(bloc3.getY() - 50);
			
			bloc4.setY(bloc4.getY() - 100);
			
			this.setIndexRotate(1);
			
		} else {
			System.out.println("erreur dans la rotation de la pièce");
		}
		
	}
	
	// permet de tourner la pièce à gauche
	public void rotateLeft(int position) {
		if(position == 1) {
			
			bloc1.setX(bloc1.getX() - 50);
			bloc1.setY(bloc1.getY() - 50);
			
			bloc3.setX(bloc3.getX() + 50);
			bloc3.setY(bloc3.getY() + 50);
			
			bloc4.setY(bloc4.getY() + 100);
			
			this.setIndexRotate(4);
			
			
			
		} else if (position == 2) {
			
			bloc1.setX(bloc1.getX() + 50);
			bloc1.setY(bloc1.getY() - 50);
			
			bloc3.setX(bloc3.getX() - 50);
			bloc3.setY(bloc3.getY() + 50);
			
			bloc4.setX(bloc4.getX() - 100);
			
			this.setIndexRotate(1);
			
		} else if (position == 3) {
			
			bloc1.setX(bloc1.getX() + 50);
			bloc1.setY(bloc1.getY() + 50);
			
			bloc3.setX(bloc3.getX() - 50);
			bloc3.setY(bloc3.getY() - 50);
			
			bloc4.setY(bloc4.getY() - 100);
			
			this.setIndexRotate(2);
			
		} else if (position == 4) {
			
			bloc1.setX(bloc1.getX() - 50);
			bloc1.setY(bloc1.getY() + 50);
			
			bloc3.setX(bloc3.getX() + 50);
			bloc3.setY(bloc3.getY() - 50);
			
			bloc4.setX(bloc4.getX() + 100);
			
			this.setIndexRotate(3);
			
		} else {
			System.out.println("erreur dans la rotation de la pièce");
		}
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

	// permet de savoir si la pièce est verticale (tournée) ou non
	public int getIndexRotate() {
		return indexRotate;
	}
	
	// permet de définir si la pièce est verticale (tournée) ou non
	public void setIndexRotate(int indexRotate) {
		this.indexRotate = indexRotate;
	}

	public boolean isMovable() {
		return isMovable;
	}
	
	// pour savoir si la pièce est en mouvement, on met en mouvement ou non tous les Tetriminos de notre pièces
	public void setMovable(boolean isMovable) {
		if(isMovable) {
			bloc1.setMovable(true);
			bloc2.setMovable(true);
			bloc3.setMovable(true);
			bloc4.setMovable(true);
			this.isMovable = isMovable;
		} else {
			bloc1.setMovable(false);
			bloc2.setMovable(false);
			bloc3.setMovable(false);
			bloc4.setMovable(false);
			this.isMovable = isMovable;
		}
	}
	
	// renvoie un tableau avec les informations sur tous les blocs de notre pièce
	public Tetriminos[] getBlocks() {
		Tetriminos[] myBlocks = {bloc1, bloc2, bloc3, bloc4};
		return myBlocks;
	}

	@Override
	public String toString() {
		return "TetriminosL [color=" + color + ", bloc1=" + bloc1 + ", bloc2=" + bloc2 + ", bloc3=" + bloc3
				+ ", bloc4=" + bloc4 + "]";
	}
}
