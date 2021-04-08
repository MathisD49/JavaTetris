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
	public final ArrayList<Tetriminos> blocks = new ArrayList<>();
	boolean isObstacle = false;
	
	// à remettre pour l'exemple
	Tetriminos square = new Tetriminos(Color.blue, 50, 50, 150, 850);
	Tetriminos square2 = new Tetriminos(Color.blue, 50, 50, 200, 800);
	TetriminosS squareline = new TetriminosS();
	
	Tetriminos square3 = new Tetriminos(Color.blue, 50, 50, 200, 850);
//	Tetriminos square4 = new Tetriminos(Color.blue, 50, 50, 200, 850);
	
	Tetriminos highestBlock = new Tetriminos(Color.red, 1, 1, 0, 900);
	
	private GameContainer gc;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// on ajoute les blocs dès le début du code (pour éviter les duplications dans la liste blocks)
		blocks.add(square);
		blocks.add(square2);
		blocks.add(square3);
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		// création d'une variable pour accueillir le bloc le plus haut sur le même axe X que la pièce 
		
		// détermination du bloc le plus haut dans la liste "blocks"
		
		// script pour définir le bloc le plus haut.
		int count = 0;
		// création d'une liste qui contiendra tous les highestBlock pour les différents AxeX de la pièce
		Tetriminos listHighestBlock[] = new Tetriminos[4];
		for (Tetriminos xAxe : squareline.getBlocks()) {
			Tetriminos intermediateHighestBlock = new Tetriminos(Color.red, 1, 1, 0, 900);
			for (Tetriminos tetri : blocks) {
				if(tetri.getX() == xAxe.getX() && tetri.getY() < intermediateHighestBlock.getY()) {
					intermediateHighestBlock = tetri;
				}
			}
			listHighestBlock[count] = intermediateHighestBlock;
			count ++;
		}
		
		System.out.println(listHighestBlock[0]);
		
		
		
		
		// vérification qu'il n'y a pas de bloc sur sa route ou qu'il arrive au bout (si oui il avance)
		
		boolean isObstacle = false;
		if(squareline.isMovable()) {
			for(Tetriminos myBlock : squareline.getBlocks()) {
				for(Tetriminos myHighestBlock : listHighestBlock) {
					if(myBlock.getY() == myHighestBlock.getY()-50 && myBlock.getX() == myHighestBlock.getX() || myBlock.getY() == 850) {
						isObstacle = true;
						squareline.setMovable(false);
					}
				}
			}
			
			if(!squareline.isMovable()) {
				for(Tetriminos block : squareline.getBlocks()) {
					blocks.add(block);
				}
			}
			
			if(!isObstacle) {
				squareline.goDown();
			}
		}	
		
		if (gc.getInput().isKeyPressed(Input.KEY_G)) {
			boolean isBorder = false;
			for(Tetriminos block : squareline.getBlocks()) {
				if(block.getX() == 0) {
					isBorder = true;
				}
			}
			if(!isBorder) {
				squareline.goLeft();
			}
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_H)) {
			boolean isBorder = false;
			for(Tetriminos block : squareline.getBlocks()) {
				if(block.getX() == 450) {
					isBorder = true;
				}
			}
			if(!isBorder) {
				squareline.goRight();
			}
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_F)) {
			//squareline.rotate(squareline.isVertical());
			squareline.rotateLeft(squareline.getIndexRotate());
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_J)) {
			squareline.rotateRight(squareline.getIndexRotate());
			
		}
		
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		for (Tetriminos tetri: blocks) {
			tetri.setColor(Color.blue);
			tetri.createItem(g);
		}
		square.createItem(g);
		squareline.createItem(g);
		square2.createItem(g);	
		square3.createItem(g);
		
		g.setColor(Color.white);
		
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


// TODO :
// ATTENTION /!\
// pour la rotation changer isVertical de Line avec une index (comme T)
// sinon ça posera problème lors de l'appel
// getter pour indexRotate et lui donner en paramètre
// A VOIR PLUS TARD


// pour générer de nouveaux blocs automatiquement : regarder les deux conditions (855 / Y)
// et si une des deux est rempli, on fait nos trucs, on laisse 2 sec et on genere un nouveau block
// utiliser instanceOf ou creer une nouvelle classe pour générer un nouveau bloc

// faire une tableau qui contient les coordonnées de toutes les pièces qui le génèrera à chaque update
// quand une pièce isMovable(false) on l'ajoute au tableau
// la variable square aura un autre bloc

//pour la descente des pieces quand on supprime une ligne dire à tous les blocs du dessus de descendre de 50 (ou 50*ligne_supprime)

// TODO :
// génération automatique nouvelles pièces
// creer variable : Object myItem;
// avec un random, définir quel type de pièce : myItem = new TetriminosO();
// pour finir définir vraiment l'objet :
// if(myItem instanceof TetriminosO){
//	TetriminosO item = (TetriminosO) myItem;
//}