package fr.campusacademy.tetris.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

//Class pour g?n?rer la pi?ce O
public class TetriminosO extends Tetriminos{
	private Color color;
	
	private boolean isMovable = true;
	
	private int indexRotate = 1;
	
	// on va instancier les bloc pour cr?er notre pi?ce
	private Tetriminos bloc1 = new Tetriminos(Color.yellow, 50, 50, 100, 0);
	private Tetriminos bloc2 = new Tetriminos(Color.yellow, 50, 50, 150, 0);
	private Tetriminos bloc3 = new Tetriminos(Color.yellow, 50, 50, 100, 50);
	private Tetriminos bloc4 = new Tetriminos(Color.yellow, 50, 50, 150, 50);
	
	public TetriminosO() {
		
	}
	
	public TetriminosO(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		bloc1 = new Tetriminos(Color.yellow, 50, 50, x1, y1);
		bloc2 = new Tetriminos(Color.yellow, 50, 50, x2, y2);
		bloc3 = new Tetriminos(Color.yellow, 50, 50, x3, y3);
		bloc4 = new Tetriminos(Color.yellow, 50, 50, x4, y4);
	}
	
	// fonction ? appeler pour cr?er visuellement la pi?ce
	public void createItem(Graphics g) {
		bloc1.createItem(g);
		bloc2.createItem(g);
		bloc3.createItem(g);
		bloc4.createItem(g);
	}
	
	// permet de faire descendre la pi?ce
	public void goDown() {
		bloc1.setY(bloc1.getY() + 50);
		bloc2.setY(bloc2.getY() + 50);
		bloc3.setY(bloc3.getY() + 50);
		bloc4.setY(bloc4.getY() + 50);
	}
	
	// permet de d?placer la pi?ce ? droite
	public void goRight() {
		bloc1.setX(bloc1.getX() + 50);
		bloc2.setX(bloc2.getX() + 50);
		bloc3.setX(bloc3.getX() + 50);
		bloc4.setX(bloc4.getX() + 50);
	}
	
	// permet de d?placer la pi?ce ? gauche
	public void goLeft() {
		bloc1.setX(bloc1.getX() - 50);
		bloc2.setX(bloc2.getX() - 50);
		bloc3.setX(bloc3.getX() - 50);
		bloc4.setX(bloc4.getX() - 50);
	}
	
	// on fait deux m?thodes vide car ici la rotation est inutile
	public void rotateLeft(int position) {}
	
	public void rotateRight(int position) {}
	
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

	public boolean isMovable() {
		return isMovable;
	}
	
	// pour savoir si la pi?ce est en mouvement, 
	// on met en mouvement ou non tous les Tetriminos de notre pi?ce
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
	
	// renvoie un tableau avec les informations sur tous les blocs de notre pi?ce
	public Tetriminos[] getBlocks() {
		Tetriminos[] myBlocks = {bloc1, bloc2, bloc3, bloc4};
		return myBlocks;
	}
	
	public int getIndexRotate() {
		return indexRotate;
	}
	
	public void setIndexRotate(int index) {
		indexRotate = 1;
	}

	@Override
	public String toString() {
		return "TetriminosO [color=" + color + ", bloc1=" + bloc1 + ", bloc2=" + bloc2 + ", bloc3=" + bloc3
				+ ", bloc4=" + bloc4 + "]";
	}
}
