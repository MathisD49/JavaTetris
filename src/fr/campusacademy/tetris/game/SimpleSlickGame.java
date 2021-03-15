package fr.campusacademy.tetris.game;

import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SimpleSlickGame extends BasicGame
{
	
	int position = 0;
	int xAxe = 100;
	private final int size = 50;
	private final ArrayList<Tetriminos> blocks = new ArrayList<>();
	
	// à remettre pour l'exemple
//	Tetriminos square = new Tetriminos(Color.blue, 50, 50, 100, 850);
//	Tetriminos square2 = new Tetriminos(Color.blue, 50, 50, 150, 850);
	TetriminosI squareline = new TetriminosI();
	
//	Tetriminos square3 = new Tetriminos(Color.blue, 50, 50, 200, 850);
//	Tetriminos square4 = new Tetriminos(Color.blue, 50, 50, 200, 850);
	
	Tetriminos highestBlock = new Tetriminos(Color.red, 1, 1, 0, 900);
	
	
	
	
	int[] Ycoordinate = {850};
	
	private GameContainer gc;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		// création d'une variable pour accueillir le bloc le plus haut sur le même axe X que la pièce 
		
		// détermination du bloc le plus haut dans la liste "blocks"
		
		// à remettre pour l'exemple
//		for(Tetriminos tetri : blocks) {			
//			if(highestBlock.getX() == square.getX()) {
//				if(tetri.getX() == square.getX() && tetri.getY() < highestBlock.getY()) {
//					highestBlock = tetri;
//				}
//			}else {
//				highestBlock = new Tetriminos(Color.red, 1, 1, 0, 900);
//				if(tetri.getX() == square.getX() && tetri.getY() < highestBlock.getY()) {
//					highestBlock = tetri;
//				}
//			}
//		}
		
		
		
		
		// vérification qu'il n'y a pas de bloc sur sa route ou qu'il arrive au bout (si oui il avance)
		// à remettre pour l'exemple
//		if(square.isMovable()) {
//			if (square.getY() != highestBlock.getY()-50 && square.getX() == highestBlock.getX() && square.getY() != 850) {
//				square.setY(square.getY() + 50);
//			} else if (square.getY() != highestBlock.getY()-50 && square.getX() != highestBlock.getX() && square.getY() != 850){
//				square.setY(square.getY() + 50);
//			} else if(square.getY() == highestBlock.getY()-50 && square.getX() != highestBlock.getX() && square.getY() != 850) {
//				square.setY(square.getY() + 50);
//			} else {
//				square.setMovable(false);
//				blocks.add(square);
//			}
//		}
		
		
		
		
//		System.out.println("highestBlock : " + highestBlock.getX() + " | " + highestBlock.getY());
//		System.out.println("square : " + square.getX() + " | " + square.getY() + "\n");
		
		// les deux autres conditions : && square.isMovable() && square.getX()-50 != -50 (obstacle + cote)
		
		if (gc.getInput().isKeyPressed(Input.KEY_G)) {
			//à remettre pour l'exemple
			//square.setX(square.getX() - 50);
			squareline.goLeft();
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_H)) {
			//à remettre pour l'exemple
			//square.setX(square.getX() + 50);
			squareline.goRight();
		}
//		
		if (gc.getInput().isKeyPressed(Input.KEY_F)) {
			//squareline.rotate(squareline.isVertical());
			squareline.rotateRight(squareline.isVertical());
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_J)) {
			squareline.rotateRight(squareline.isVertical());
			
		}
		
		squareline.goDown();
		
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		for (Tetriminos tetri: blocks) {
			tetri.setColor(Color.blue);
			tetri.createItem(g);
		}
		
		//g.drawString("x : " + square.getX() + " | y : " + square.getY(), 100, 100);
		//g.drawString("x : " + squareline.getBloc4().getX() + " | y : " + squareline.getBloc4().getY(), 100, 100);
		
		//à remettre pour l'exemple
		//square.createItem(g);
		
		squareline.createItem(g);
		
//		g.drawString("x : " + square2.getX() + " | y : " + square2.getY(), 120, 120);
//		square2.createItem(g);
//		blocks.add(square2);
//		g.drawString("coordinate : " + Ycoordinate[0], 140, 140);
//		
//		square3.createItem(g);
//		blocks.add(square3);
		
		
		g.setColor(Color.white);
		
		// à remettre pour l'exemple
//		if(!square.isMovable()) {
//			square = new Tetriminos(Color.red, 50, 50, 100, 0);
//			square.createItem(g);
//		}
		
		
		// quadrillage
		for (int i = 0; i < 50; i++) {
			float y = i*size;
			float x = 0;
			g.drawLine(x, y, gc.getWidth(), y);
			
			for (int j = 0; j < 50; j++) {
				float x2 = j*size;
				g.drawLine(x2, y, x2, gc.getHeight());
			}
		}
		
	}
	
	
	
	@Override
	public void keyReleased(int key, char c) {
		if (Input.KEY_ESCAPE == key) {
			gc.exit();
		}
	}
}



// pour générer de nouveaux blocs automatiquement : regarder les deux conditions (855 / Y)
// et si une des deux est rempli, on fait nos trucs, on laisse 2 sec et on genere un nouveau block

// faire une tableau qui contient les coordonnées de toutes les pièces qui le génèrera à chaque update
// quand une pièce isMovable(false) on l'ajoute au tableau
// la variable square aura un autre bloc

// pour chaque pièce creer une methode pour aller vers le bas (+conditions) et bouger etc et les appeler ensuite dans le code ici

//pour la descente des pieces quand on supprime une ligne dire à tous les blocs du dessus de descendre de 50 (ou 50*ligne_supprime)
