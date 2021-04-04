package fr.campusacademy.tetris.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TetriminosT extends Tetriminos{
	private Color color;
	
	private boolean isVertical = false;
	
	private boolean isMovable = true;
	
	private int indexRotate = 1;
	
	
	private Tetriminos bloc1 = new Tetriminos(Color.red, 50, 50, 100, 50); // C
	private Tetriminos bloc2 = new Tetriminos(Color.blue, 50, 50, 150, 50); // A
	private Tetriminos bloc3 = new Tetriminos(Color.pink, 50, 50, 150, 0); // B
	private Tetriminos bloc4 = new Tetriminos(Color.green, 50, 50, 200, 50); // D
	
	public TetriminosT() {
		
	}
	
	public void createItem(Graphics g) {
		bloc1.createItem(g);
		bloc2.createItem(g);
		bloc3.createItem(g);
		bloc4.createItem(g);
	}
	
	// permet de faire d�scendre la pi�ce
	public void goDown() {
		bloc1.setY(bloc1.getY() + 50);
		bloc2.setY(bloc2.getY() + 50);
		bloc3.setY(bloc3.getY() + 50);
		bloc4.setY(bloc4.getY() + 50);
	}
	
	// permet de d�placer la pi�ce � droite
	public void goRight() {
		bloc1.setX(bloc1.getX() + 50);
		bloc2.setX(bloc2.getX() + 50);
		bloc3.setX(bloc3.getX() + 50);
		bloc4.setX(bloc4.getX() + 50);
	}
	
	// permet de d�placer la pi�ce � gauche
	public void goLeft() {
		bloc1.setX(bloc1.getX() - 50);
		bloc2.setX(bloc2.getX() - 50);
		bloc3.setX(bloc3.getX() - 50);
		bloc4.setX(bloc4.getX() - 50);
	}
	
	// permet de tourner la pi�ce � droite
	public void rotateRight() {			
		if(indexRotate == 1) {
			bloc3.setX(bloc3.getX() + 50);
			bloc3.setY(bloc3.getY() + 50);
			
			bloc1.setX(bloc1.getX() + 50);
			bloc1.setY(bloc1.getY() - 50);
			
			bloc4.setX(bloc4.getX() - 50);
			bloc4.setY(bloc4.getY() + 50);
			
			indexRotate = 2;
			
			
			
		} else if (indexRotate == 2) {
			bloc3.setX(bloc3.getX() - 50);
			bloc3.setY(bloc3.getY() + 50);
			
			bloc1.setX(bloc1.getX() + 50);
			bloc1.setY(bloc1.getY() + 50);
			
			bloc4.setX(bloc4.getX() - 50);
			bloc4.setY(bloc4.getY() - 50);
			
			indexRotate = 3;
			
		} else if (indexRotate == 3) {
			bloc3.setX(bloc3.getX() - 50);
			bloc3.setY(bloc3.getY() - 50);
			
			bloc1.setX(bloc1.getX() - 50);
			bloc1.setY(bloc1.getY() + 50);
			
			bloc4.setX(bloc4.getX() + 50);
			bloc4.setY(bloc4.getY() - 50);
			
			indexRotate = 4;
			
		} else if (indexRotate == 4) {
			bloc3.setX(bloc3.getX() + 50);
			bloc3.setY(bloc3.getY() - 50);
			
			bloc1.setX(bloc1.getX() - 50);
			bloc1.setY(bloc1.getY() - 50);
			
			bloc4.setX(bloc4.getX() + 50);
			bloc4.setY(bloc4.getY() + 50);
			
			indexRotate = 1;
			
		} else {
			System.out.println("erreur dans la rotation de la pi�ce");
		}
		
	}
	
	// permet de tourner la pi�ce � gauche
	public void rotateLeft() {
		if(indexRotate == 1) {
			bloc3.setX(bloc3.getX() - 50);
			bloc3.setY(bloc3.getY() + 50);
			
			bloc1.setX(bloc1.getX() + 50);
			bloc1.setY(bloc1.getY() + 50);
			
			bloc4.setX(bloc4.getX() - 50);
			bloc4.setY(bloc4.getY() - 50);
			
			indexRotate = 4;
			
			
			
		} else if (indexRotate == 2) {
			bloc3.setX(bloc3.getX() - 50);
			bloc3.setY(bloc3.getY() - 50);
			
			bloc1.setX(bloc1.getX() - 50);
			bloc1.setY(bloc1.getY() + 50);
			
			bloc4.setX(bloc4.getX() + 50);
			bloc4.setY(bloc4.getY() - 50);
			
			indexRotate = 1;
			
		} else if (indexRotate == 3) {
			bloc3.setX(bloc3.getX() + 50);
			bloc3.setY(bloc3.getY() - 50);
			
			bloc1.setX(bloc1.getX() - 50);
			bloc1.setY(bloc1.getY() - 50);
			
			bloc4.setX(bloc4.getX() + 50);
			bloc4.setY(bloc4.getY() + 50);
			
			indexRotate = 2;
			
		} else if (indexRotate == 4) {
			bloc3.setX(bloc3.getX() + 50);
			bloc3.setY(bloc3.getY() + 50);
			
			bloc1.setX(bloc1.getX() + 50);
			bloc1.setY(bloc1.getY() - 50);
			
			bloc4.setX(bloc4.getX() - 50);
			bloc4.setY(bloc4.getY() + 50);
			
			indexRotate = 3;
			
		} else {
			System.out.println("erreur dans la rotation de la pi�ce");
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

	// permet de savoir si la pi�ce est verticale (tourn�e) ou non
	public boolean isVertical() {
		return isVertical;
	}

	// permet de d�finir si la pi�ce est verticale (tourn�e) ou non
	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}

	public boolean isMovable() {
		return isMovable;
	}
	
	// pour savoir si la pi�ce est en mouvement, on met en mouvement ou non tous les Tetriminos de notre pi�ces
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
	
	// renvoie un tableau avec les informations sur tous les blocs de notre pi�ce
	public Tetriminos[] getBlocks() {
		Tetriminos[] myBlocks = {bloc1, bloc2, bloc3, bloc4};
		return myBlocks;
	}

	@Override
	public String toString() {
		return "LineTetriminos [color=" + color + ", bloc1=" + bloc1 + ", bloc2=" + bloc2 + ", bloc3=" + bloc3
				+ ", bloc4=" + bloc4 + "]";
	}
}
