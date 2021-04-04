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
	
	// � remettre pour l'exemple
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
		// on ajoute les blocs d�s le d�but du code (pour �viter les duplications dans la liste blocks)
		blocks.add(square);
		blocks.add(square2);
		blocks.add(square3);
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		// cr�ation d'une variable pour accueillir le bloc le plus haut sur le m�me axe X que la pi�ce 
		
		// d�termination du bloc le plus haut dans la liste "blocks"

		// TODO : trouver le highestBlock de ma pi�ce
		//	creer une variable interm�diaire qui contiendra les coor d'un bloc
		//	parcourir les 4 blocs de notre pi�ces
		// 	� chaque bloc voir la pi�ce la plus haute sur l'axe X du cube
		// 	si un bloc est plus haut que le pr�c�dent, le remplacer dans la variable interm�diaire
		// 	d�finir notre highestBlock avec le bloc trouv�.
		
		// � remettre pour l'exemple
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
		
		// script pour d�finir le bloc le plus haut.
		//int[] xAxes = {squareline.getBloc1().getX(), squareline.getBloc1().getX()+50, squareline.getBloc1().getX()+100, squareline.getBloc1().getX()+150};
		Tetriminos intermediateHighestBlock = new Tetriminos(Color.red, 1, 1, 0, 900);
		for (Tetriminos xAxe : squareline.getBlocks()) {
			for (Tetriminos tetri : blocks) {
				if(tetri.getX() == xAxe.getX() && tetri.getY() < intermediateHighestBlock.getY()) {
					intermediateHighestBlock = tetri;
				}
			}
		}
		highestBlock = intermediateHighestBlock;
		
		//System.out.println(highestBlock);
		System.out.println(blocks);
		
		
		
		
		// v�rification qu'il n'y a pas de bloc sur sa route ou qu'il arrive au bout (si oui il avance)
		// � remettre pour l'exemple
		
		// TODO: syst�me collision
		//	Prendre le m�me algo et boucler sur chaque blocs de ma pi�ce
//		if(squareline.isMovable()) {
//			boolean test = true;
//			for(Tetriminos myBlock : squareline.getBlocks()) {
//				if (squareline.getY() != highestBlock.getY()-50 && squareline.getX() == highestBlock.getX() && squareline.getY() != 850) {
//					test = true;
//				} else if (squareline.getY() != highestBlock.getY()-50 && squareline.getX() != highestBlock.getX() && squareline.getY() != 850){
//					test = true;
//				} else if(squareline.getY() == highestBlock.getY()-50 && squareline.getX() != highestBlock.getX() && squareline.getY() != 850) {
//					test = true;
//				} else {
//					test = false;
//					squareline.setMovable(false);
//					System.out.println("yo");
//					for(Tetriminos myBlocks : squareline.getBlocks()) {
//						blocks.add(myBlocks);
//					}
//				}
//			}
//			if(test) {
//				salut++;
//				squareline.goDown();
//				System.out.println(salut);
//			}
//		}
		
		boolean isObstacle = false;
		if(squareline.isMovable()) {
			for(Tetriminos myBlock : squareline.getBlocks()) {
				if(myBlock.getY() == highestBlock.getY()-50 && myBlock.getX() == highestBlock.getX() || myBlock.getY() == 850) {
					isObstacle = true;
					squareline.setMovable(false);
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
		
		
		
		// pour tous les blocs faire une confition qui dit : si un bloc � les m�mes coords que le highestbloc || y = 850 => stop SINON goDown();
		
		
		
//		if(squareline.getBloc1().getY() != 850 || squareline.getBloc2().getY() != 850 || squareline.getBloc3().getY() != 850 || squareline.getBloc4().getY() != 850) {
//			squareline.goDown();
//		}
		
		
		
		
//		System.out.println("highestBlock : " + highestBlock.getX() + " | " + highestBlock.getY());
//		System.out.println("square : " + square.getX() + " | " + square.getY() + "\n");
		
		// les deux autres conditions : && square.isMovable() && square.getX()-50 != -50 (obstacle + cote)
		
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
//		
		if (gc.getInput().isKeyPressed(Input.KEY_F)) {
			//squareline.rotate(squareline.isVertical());
			squareline.rotateLeft();
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_J)) {
			squareline.rotateRight();
			
		}
		
		
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
		
		//� remettre pour l'exemple
		square.createItem(g);
		squareline.createItem(g);
		
//		g.drawString("x : " + square2.getX() + " | y : " + square2.getY(), 120, 120);
		square2.createItem(g);
//		blocks.add(square2);
//		g.drawString("coordinate : " + Ycoordinate[0], 140, 140);
//		
		square3.createItem(g);
		
		
		g.setColor(Color.white);
		
		// � remettre pour l'exemple
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


// TODO :
// ATTENTION /!\
// pour la rotation changer isVertical de Line avec une index (comme T)
// sinon �a posera probl�me lors de l'appel
// getter pour indexRotate et lui donner en param�tre
// A VOIR PLUS TARD


// pour g�n�rer de nouveaux blocs automatiquement : regarder les deux conditions (855 / Y)
// et si une des deux est rempli, on fait nos trucs, on laisse 2 sec et on genere un nouveau block
// utiliser instanceOf ou creer une nouvelle classe pour g�n�rer un nouveau bloc

// faire une tableau qui contient les coordonn�es de toutes les pi�ces qui le g�n�rera � chaque update
// quand une pi�ce isMovable(false) on l'ajoute au tableau
// la variable square aura un autre bloc

// pour chaque pi�ce creer une methode pour aller vers le bas (+conditions) et bouger etc et les appeler ensuite dans le code ici

//pour la descente des pieces quand on supprime une ligne dire � tous les blocs du dessus de descendre de 50 (ou 50*ligne_supprime)

// faire un tableau qui contiendra les 4 object bloc de chaques pi�ces, enuite faire une boucle qui parcours la liste et utiliser les anciennes conditions sur chacun d'eux