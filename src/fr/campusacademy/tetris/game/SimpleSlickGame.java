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
	
	// mettre la variable receveuse en Object ou Tetriminos et ensuite faire un cast
	
	public final ArrayList<TypeArrayList> test2 = new ArrayList<>();
	
	// peut �tre utiliser �a pour le changement de type
	TetriminosT squareline = new TetriminosT();
	
	double nombre = Math.random();
	
	// cr�ation variable Tetriminos test = quelque chose
	// condition pour creer ls pi�ces ex : TetriminosT iez = new TetriminosT....
	// dedans on dit test = notre nouvelle pi�ce
	// if test instanceof.... -> squareline bla bla bla
		
	Tetriminos square3 = new Tetriminos(Color.blue, 50, 50, 200, 850);
	Tetriminos square4 = new Tetriminos(Color.blue, 50, 50, 200, 850);
	
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
		
		test2.add(new TypeArrayList(nombre));
		System.out.println(test2.get(0).getBlocks(nombre));
		
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		// cr�ation d'une variable pour accueillir le bloc le plus haut sur le m�me axe X que la pi�ce 
		
		// d�termination du bloc le plus haut dans la liste "blocks"
		
		// script pour d�finir le bloc le plus haut.
		int count = 0;
		// cr�ation d'une liste qui contiendra tous les highestBlock pour les diff�rents AxeX de la pi�ce
		Tetriminos listHighestBlock[] = new Tetriminos[4];
		for (Tetriminos xAxe : test2.get(0).getBlocks(nombre)) {
			Tetriminos intermediateHighestBlock = new Tetriminos(Color.red, 1, 1, 0, 900);
			for (Tetriminos tetri : blocks) {
				if(tetri.getX() == xAxe.getX() && tetri.getY() < intermediateHighestBlock.getY()) {
					intermediateHighestBlock = tetri;
				}
			}
			listHighestBlock[count] = intermediateHighestBlock;
			count ++;
		}
		
		// v�rification qu'il n'y a pas de bloc sur sa route ou qu'il arrive au bout (si oui il avance)
		
		boolean isObstacle = false;
		if(test2.get(0).isMovable(nombre)) {
			for(Tetriminos myBlock : test2.get(0).getBlocks(nombre)) {
				for(Tetriminos myHighestBlock : listHighestBlock) {
					if(myBlock.getY() == myHighestBlock.getY()-50 && myBlock.getX() == myHighestBlock.getX() || myBlock.getY() == 850) {
						isObstacle = true;
						test2.get(0).setMovable(false, nombre);
					}
				}
			}
			
			if(!test2.get(0).isMovable(nombre)) {
				for(Tetriminos block : test2.get(0).getBlocks(nombre)) {
					blocks.add(block);
				}
				test2.remove(0);
				nombre = Math.random();
				test2.add(new TypeArrayList(nombre));
				
			}
			
			if(!isObstacle) {
				test2.get(0).goDown(nombre);
			}
		}	
		
		if (gc.getInput().isKeyPressed(Input.KEY_G)) {
			boolean isBorder = false;
			for(Tetriminos block : test2.get(0).getBlocks(nombre)) {
				if(block.getX() == 0) {
					isBorder = true;
				}
			}
			if(!isBorder) {
				test2.get(0).goLeft(nombre);
			}
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_H)) {
			boolean isBorder = false;
			for(Tetriminos block : test2.get(0).getBlocks(nombre)) {
				if(block.getX() == 450) {
					isBorder = true;
				}
			}
			if(!isBorder) {
				test2.get(0).goRight(nombre);
			}
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_F)) {
			//squareline.rotate(squareline.isVertical());
			test2.get(0).rotateLeft(test2.get(0).getIndexRotate(nombre), nombre);
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_J)) {
			test2.get(0).rotateRight(test2.get(0).getIndexRotate(nombre), nombre);
			
		}
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
		for (Tetriminos tetri: blocks) {
			tetri.setColor(Color.blue);
			tetri.createItem(g);
		}
		square.createItem(g);
		test2.get(0).createItem(g, nombre);
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
// sinon �a posera probl�me lors de l'appel
// getter pour indexRotate et lui donner en param�tre
// A VOIR PLUS TARD


// pour g�n�rer de nouveaux blocs automatiquement : regarder les deux conditions (855 / Y)
// et si une des deux est rempli, on fait nos trucs, on laisse 2 sec et on genere un nouveau block
// utiliser instanceOf ou creer une nouvelle classe pour g�n�rer un nouveau bloc

// faire une tableau qui contient les coordonn�es de toutes les pi�ces qui le g�n�rera � chaque update
// quand une pi�ce isMovable(false) on l'ajoute au tableau
// la variable square aura un autre bloc

//pour la descente des pieces quand on supprime une ligne dire � tous les blocs du dessus de descendre de 50 (ou 50*ligne_supprime)

// TODO :
// g�n�ration automatique nouvelles pi�ces
// creer variable : Object myItem;
// avec un random, d�finir quel type de pi�ce : myItem = new TetriminosO();
// pour finir d�finir vraiment l'objet :
// if(myItem instanceof TetriminosO){
//	TetriminosO item = (TetriminosO) myItem;
//}


// probl�me g�n�ration pi�ce, dessus fonctionne pas
// regarder tuto dossier Brave java_tetris -> creer interface ou class et aller chercher les diff�rentes pi�ces dedans (faire tout dedans)
// essayer de bricoler entre type tetriminos / autre || truc instanceof || machin = null etc etc etc.....