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
	
	public final ArrayList<TypeArrayList> test2 = new ArrayList<>();
	
	double nombre = Math.random();
	
	Tetriminos highestBlock = new Tetriminos(Color.red, 1, 1, 0, 900);
	
	private GameContainer gc;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		test2.add(new TypeArrayList(nombre));
		System.out.println(test2.get(0).getBlocks(nombre));
		
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		// création d'une variable pour accueillir le bloc le plus haut sur le même axe X que la pièce 
		
		// détermination du bloc le plus haut dans la liste "blocks"
		
		// script pour définir le bloc le plus haut.
		int count = 0;
		// création d'une liste qui contiendra tous les highestBlock pour les différents AxeX de la pièce
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
		
		// vérification qu'il n'y a pas de bloc sur sa route ou qu'il arrive au bout (si oui il avance)
		
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
		
		test2.get(0).createItem(g, nombre);
		
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

//pour la descente des pieces quand on supprime une ligne dire à tous les blocs du dessus de descendre de 50 (ou 50*ligne_supprime)
