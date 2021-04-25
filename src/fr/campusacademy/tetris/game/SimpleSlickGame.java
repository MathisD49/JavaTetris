package fr.campusacademy.tetris.game;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

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
	boolean isObstacle = false;
	
	// instanciation des diff�rentes listes
	public final CopyOnWriteArrayList<Tetriminos> blocks = new CopyOnWriteArrayList<Tetriminos>(); //contient les blocs "inactifs"
	public final ArrayList<TypeArrayList> gameBlock = new ArrayList<>(); // contient les blocs de la pi�ce qui tombe
	public final ArrayList<PreviewTetriminos> preview = new ArrayList<>(); // contient les blocs de la pi�ces de preview
	
	// va �tre utilis� pour g�n�rer la pi�ce et une preview
	double nombre = Math.random();
	double nombre2 = Math.random();
	
	Tetriminos highestBlock = new Tetriminos(Color.red, 1, 1, 0, 900);
	
	Score score = new Score();
	
	
	private GameContainer gc;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {		
		
		// permet d'ajouter aux deux listes une pi�ce au lancement du jeu
		gameBlock.add(new TypeArrayList(nombre));
		preview.add(new PreviewTetriminos(nombre2));
		
		
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		// script pour d�finir le bloc le plus haut.
		int count = 0;
		Tetriminos listHighestBlock[] = new Tetriminos[4]; // cr�ation d'une liste qui contiendra tous les highestBlock pour les diff�rents AxeX de la pi�ce
		for (Tetriminos xAxe : gameBlock.get(0).getBlocks(nombre)) {
			Tetriminos intermediateHighestBlock = new Tetriminos(Color.red, 1, 1, 0, 900);
			for (Tetriminos tetri : blocks) {
				if(tetri.getX() == xAxe.getX() && tetri.getY() < intermediateHighestBlock.getY()) {
					intermediateHighestBlock = tetri;
				}
			}
			listHighestBlock[count] = intermediateHighestBlock;
			count ++;
		}
		
		// v�rification si la pi�ce ne rencontre pas d'obstacle (ou le bas de la fenetre)
		// si oui la pi�ce s'arr�te
		// si non elle continue de descendre
		boolean isObstacle = false;
		if(gameBlock.get(0).isMovable(nombre)) {
			for(Tetriminos myBlock : gameBlock.get(0).getBlocks(nombre)) {
				for(Tetriminos myHighestBlock : listHighestBlock) {
					if(myBlock.getY() == myHighestBlock.getY()-50 && myBlock.getX() == myHighestBlock.getX() || myBlock.getY() == 850) {
						isObstacle = true;
						gameBlock.get(0).setMovable(false, nombre);
					} else if (myBlock.getY() == myHighestBlock.getY() && myBlock.getY() == 0) { // mise en place d'un GAME OVER quand il n'y a plus de place pour faire spawn une pi�ce
						System.out.println("GAME OVER  !!!!!!!!!");
						gc.exit();
					}
				}
			}
			
			// si la pi�ce rencontre un obstable ses blocs sont ajout�s � la liste des blocs "inactifs"
			if(!gameBlock.get(0).isMovable(nombre)) {
				for(Tetriminos block : gameBlock.get(0).getBlocks(nombre)) {
					blocks.add(block);
					
				}
				
				// script pour regarder si une ligne est pleine et si oui, la supprimer et faire descendre les blocs au dessus
				for(int j = 0; j<=850; j = j+50) {
					int ligne = 0;
					for(Tetriminos tetri : blocks) {
						if(tetri.getY() == j) {
							ligne++;
						}
					}
					
					if(ligne >= 10) {
						for(Tetriminos tetri : blocks) {
							if(tetri.getY() == j) {
								blocks.remove(blocks.indexOf(tetri));
							}
						}
						
						// r�cup�re le nombre de lignes supprim�s pour le score
						score.setNbLigne(score.getNbLigne() + 1);
						
						
						for(Tetriminos tetri : blocks) {
							if(tetri.getY() < j) {
								tetri.setY(tetri.getY() + 50);
							}
						}
						
					}
					
				}
				
				// calcul le score par rapport au nombre de ligne supprim�e et remet le nombre de ligne � 0
				score.calculerScore(score.getNbLigne());
				score.setNbLigne(0);
				
				// premet de g�n�rer une pi�ce � partir de celle de preview et de reg�n�rer une nouvelle pi�ce de preview
				gameBlock.remove(0);
				nombre = nombre2;
				gameBlock.add(new TypeArrayList(nombre));
				preview.remove(0);
				nombre2 = Math.random();
				preview.add(new PreviewTetriminos(nombre2));
				
				
			}
			
			// permet de faire descendre la pi�ce
			if(!isObstacle) {
				gameBlock.get(0).goDown(nombre);
			}
		}
		
		
		
		if (gc.getInput().isKeyPressed(Input.KEY_LEFT)) {
			// script permettant de voir si il y a un bloc sur la gauche
			boolean isBorder = false;
			for(Tetriminos block : gameBlock.get(0).getBlocks(nombre)) {
				if(block.getX() == 0) {
					isBorder = true;
				}
			}
			
			for(Tetriminos tetri : blocks) {
				for(Tetriminos block : gameBlock.get(0).getBlocks(nombre)) {
					if(block.getX() - 50 == tetri.getX() && block.getY() == tetri.getY()) {
						isBorder = true;
					}
				}
			}
			
			// si il n'y a pas de blocs, la pi�ce peut aller � gauche
			if(!isBorder) {
				gameBlock.get(0).goLeft(nombre);
			}
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_RIGHT)) {
			// script permettant de voir si il y a un bloc sur la droite
			boolean isBorder = false;
			for(Tetriminos block : gameBlock.get(0).getBlocks(nombre)) {
				if(block.getX() == 450) {
					isBorder = true;
				}
			}
			
			
			for(Tetriminos tetri : blocks) {
				for(Tetriminos block : gameBlock.get(0).getBlocks(nombre)) {
					if(block.getX() + 50 == tetri.getX() && block.getY() == tetri.getY()) {
						isBorder = true;
					}
				}
			}
			
			// si il n'y a pas de blocs, la pi�ce peut aller � gauche
			if(!isBorder) {
				gameBlock.get(0).goRight(nombre);
			}
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_DOWN)) {
			// va permetre la rotation vers la gauche de la pi�ce
			gameBlock.get(0).rotateLeft(gameBlock.get(0).getIndexRotate(nombre), nombre);
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_UP)) {
			// va permetre la rotation vers la droite de la pi�ce
			gameBlock.get(0).rotateRight(gameBlock.get(0).getIndexRotate(nombre), nombre);
			
		}
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
		// zone de jeu
		g.setColor(Color.white);
		g.fillRect(0, 0, 500, 900);
		
		// zone avec les donn�es
		g.setColor(Color.black);
		g.fillRect(500, 0, 200, 900);
		
		// zone de preview
		g.setColor(Color.lightGray);
		g.fillRect(500, 700, 200, 200);
		
		// permet de creer sur la zone de jeu les blocs inactifs
		for (Tetriminos tetri: blocks) {
			tetri.createItem(g);
		}
		
		// creer la pi�ce de jeu et la pi�ce de preview
		gameBlock.get(0).createItem(g, nombre);
		preview.get(0).createItem(g, nombre2);
		
		// affichage du score
		g.setColor(Color.white);
		g.drawString("SCORE : ", 550, 50);
		g.drawString("" + score.getPoint(), 600, 100);
		
		
	}
	
	
	
	
	@Override
	public void keyReleased(int key, char c) {
		if (Input.KEY_ESCAPE == key) {
			gc.exit();
		}
	}
}