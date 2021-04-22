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
	public final CopyOnWriteArrayList<Tetriminos> blocks = new CopyOnWriteArrayList<Tetriminos>();
	boolean isObstacle = false;
	
	public final ArrayList<TypeArrayList> gameBlock = new ArrayList<>();
	public final ArrayList<PreviewTetriminos> preview = new ArrayList<>();
	
	double nombre = Math.random();
	double nombre2 = Math.random();
	
	Tetriminos highestBlock = new Tetriminos(Color.red, 1, 1, 0, 900);
	
	Score score = new Score();
	
	// générer le preview ici
	
	
	private GameContainer gc;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {		
		
		gameBlock.add(new TypeArrayList(nombre));
		
		preview.add(new PreviewTetriminos(nombre2));
		
		
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		// création d'une variable pour accueillir le bloc le plus haut sur le même axe X que la pièce 
		
		// détermination du bloc le plus haut dans la liste "blocks"
		
		// script pour définir le bloc le plus haut.
		int count = 0;
		// création d'une liste qui contiendra tous les highestBlock pour les différents AxeX de la pièce
		Tetriminos listHighestBlock[] = new Tetriminos[4];
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
		
		// vérification qu'il n'y a pas de bloc sur sa route ou qu'il arrive au bout (si oui il avance)
		
		boolean isObstacle = false;
		if(gameBlock.get(0).isMovable(nombre)) {
			for(Tetriminos myBlock : gameBlock.get(0).getBlocks(nombre)) {
				for(Tetriminos myHighestBlock : listHighestBlock) {
					if(myBlock.getY() == myHighestBlock.getY()-50 && myBlock.getX() == myHighestBlock.getX() || myBlock.getY() == 850) {
						isObstacle = true;
						gameBlock.get(0).setMovable(false, nombre);
					} else if (myBlock.getY() == myHighestBlock.getY() && myBlock.getY() == 0) { // mise en place d'un GAME OVER quand il n'y a plus de place pour faire spawn une pièce
						System.out.println("GAME OVER  !!!!!!!!!");
						gc.exit();
					}
				}
			}
			
			if(!gameBlock.get(0).isMovable(nombre)) {
				for(Tetriminos block : gameBlock.get(0).getBlocks(nombre)) {
					blocks.add(block);
					
				}
				
				// ceci va regarder si des blocks sont sur la derniere ligne
				
				// si la ligne est complete, il va supprimer les blocks de cette lignes puis va faire descendre tous les blocks
				
				for(int j = 0; j<=850; j = j+50) {
					int test = 0;
					for(Tetriminos tetri : blocks) {
						if(tetri.getY() == j) {
							test++;
						}
					}
					
					if(test >= 10) {
						for(Tetriminos tetri : blocks) {
							if(tetri.getY() == j) {
								blocks.remove(blocks.indexOf(tetri));
							}
						}
						score.setNbLigne(score.getNbLigne() + 1);
						
						score.calculerScore(score.getNbLigne());
						
						for(Tetriminos tetri : blocks) {
							if(tetri.getY() < j) {
								tetri.setY(tetri.getY() + 50);
							}
						}
						
					}
					score.setNbLigne(0);
					
				}
				
				// premet de générer une nouvelle pièce
				gameBlock.remove(0);
				nombre = nombre2;
				gameBlock.add(new TypeArrayList(nombre));
				preview.remove(0);
				nombre2 = Math.random();
				preview.add(new PreviewTetriminos(nombre2));
				
				
			}
			
			if(!isObstacle) {
				gameBlock.get(0).goDown(nombre);
			}
		}	
		
		if (gc.getInput().isKeyPressed(Input.KEY_LEFT)) {
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
			
			if(!isBorder) {
				gameBlock.get(0).goLeft(nombre);
			}
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_RIGHT)) {
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
			
			if(!isBorder) {
				gameBlock.get(0).goRight(nombre);
			}
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_DOWN)) {
			//squareline.rotate(squareline.isVertical());
			gameBlock.get(0).rotateLeft(gameBlock.get(0).getIndexRotate(nombre), nombre);
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_UP)) {
			gameBlock.get(0).rotateRight(gameBlock.get(0).getIndexRotate(nombre), nombre);
			
		}
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
		// zone de jeu
		g.setColor(Color.white);
		g.fillRect(0, 0, 500, 900);
		
		// zone avec les données
		g.setColor(Color.black);
		g.fillRect(500, 0, 200, 900);
		
		// zone de preview
		g.setColor(Color.lightGray);
		g.fillRect(500, 700, 200, 200);
		
		for (Tetriminos tetri: blocks) {
			tetri.createItem(g);
		}
		
		// creer la pièce de jeu et la pièce de preview
		gameBlock.get(0).createItem(g, nombre);
		preview.get(0).createItem(g, nombre2);
		
		// permet d'afficher le texte avec le score
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