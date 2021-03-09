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
		if (position == Ycoordinate[0]-50) {
			
		}else if (position != 850) {
			position = position + 50;
		}
		
		
		if (gc.getInput().isKeyPressed(Input.KEY_G)) {
			xAxe = xAxe - 50;
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_H)) {
			xAxe = xAxe + 50;
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
		Tetriminos square = new Tetriminos(Color.red, 50, 50, xAxe, position);
		g.drawString("x : " + square.getX() + " | y : " + square.getY(), 100, 100);
		square.createSquare(g);
		
		Tetriminos square2 = new Tetriminos(Color.red, 50, 50, xAxe, 850);
		g.drawString("x : " + square2.getX() + " | y : " + square2.getY(), 120, 120);
		square2.createSquare(g);
		
		g.drawString("coordinate : " + Ycoordinate[0], 140, 140);
		
		g.setColor(Color.white);
		
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

// mettre les coordonnées des cubes dans une tableau
// test : descente verticale
// pour chaque cube, vérifier à chaque étape si il n'y a pas de cube en dessous (ref : tableau)
// si oui il s'arrête là, sinon il continue, max y : 855