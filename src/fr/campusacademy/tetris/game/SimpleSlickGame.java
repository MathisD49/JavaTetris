package fr.campusacademy.tetris.game;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
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
	
	Tetriminos square = new Tetriminos(Color.red, 50, 50, 100, 0);
	Tetriminos square2 = new Tetriminos(Color.blue, 50, 50, 100, 850);
	Tetriminos square3 = new Tetriminos(Color.blue, 50, 50, 200, 850);
	
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
		
		// cr�ation d'une variable pour accueillir le bloc le plus haut sur le m�me axe X que la pi�ce 
		
		// d�termination du bloc le plus haut dans la liste "blocks"
		for(Tetriminos tetri : blocks) {
			if (tetri.getY() < highestBlock.getY() && tetri.getX() == square.getX()) {
				highestBlock = tetri;
			}
		}
		
		// v�rification qu'il n'y a pas de bloc sur sa route ou qu'il arrive au bout (si oui il avance)
		if(square.isMovable()) {
			if (square.getY() != highestBlock.getY()-50 && square.getX() == highestBlock.getX() && square.getY() != 850) {
				square.setY(square.getY() + 50);
				System.out.println("y != | x ==");
			} else if (square.getY() != highestBlock.getY()-50 && square.getX() != highestBlock.getX() && square.getY() != 850){
				square.setY(square.getY() + 50);
				System.out.println("y != | x !=");
			} else if(square.getY() == highestBlock.getY()-50 && square.getX() != highestBlock.getX() && square.getY() != 850) {
				square.setY(square.getY() + 50);
				System.out.println("y == | x !=");
			} else {
				square.setMovable(false);
			}
		}
		
		
		
		
		if (gc.getInput().isKeyPressed(Input.KEY_G) && square.isMovable() && square.getX()-50 != -50) {
			
			square.setX(square.getX() - 50);
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_H) && square.isMovable() && square.getX()+50 != 500) {
			square.setX(square.getX() + 50);
			
			
		}
		
//		if (gc.getInput().isMouseButtonDown(0)) {
//			float x = (float) Math.ceil(gc.getInput().getMouseX() / size * size);
//			float y = (float) Math.ceil(gc.getInput().getMouseY() / size * size);
//		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		//float x = (float) Math.ceil();
		g.drawString("x : " + square.getX() + " | y : " + square.getY(), 100, 100);
		square.createSquare(g);
		
		g.drawString("x : " + square2.getX() + " | y : " + square2.getY(), 120, 120);
		square2.createSquare(g);
		blocks.add(square2);
		g.drawString("coordinate : " + Ycoordinate[0], 140, 140);
		
		//g.drawString("x : " + square3.getX() + " | y : " + square3.getY(), 120, 120);
		square3.createSquare(g);
		blocks.add(square3);
		
		
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
//		g.setColor(Color.green);
//		g.fillRect(100, 0+position, 75, 75);
		
		
//		for(int i = 100; i<130; i++) {
//			g.drawRect(i, i, 30, 30);
//			g.setColor(Color.red);
//		}
		
	}
	
	@Override
	public void keyReleased(int key, char c) {
		if (Input.KEY_ESCAPE == key) {
			gc.exit();
		}
	}
}


// mettre les coordonn�es des cubes dans un tableau
// test : descente verticale
// pour chaque cube, v�rifier � chaque �tape si il n'y a pas de cube en dessous (ref : tableau)
// si oui il s'arr�te l�, sinon il continue, max y : 855

// pour g�n�rer de nouveaux blocs automatiquement : regarder les deux condition (855 / Y)
// et si une des deux est remplit, on fais nos trucs, on laisse 2 sec et on genere un nouveau block

//faire une m�thode qui quand le block est "bloqu�" il ne peux plus bouger


//quand else (deplacement vers le bas) mettre isMovable � false, si isMovable == peut bouger, sinon peut pas



