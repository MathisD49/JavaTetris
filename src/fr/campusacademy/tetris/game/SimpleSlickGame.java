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
	int xAxe = 105;
	private final int size = 50;
	private final ArrayList<Tetriminos> blocks = new ArrayList<>();
	
	private GameContainer gc;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		position = position + 50;
		
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
		g.drawString("Howdy!", 100, 100);
		Tetriminos square = new Tetriminos(Color.red, 30, 30, xAxe, 5+position);
		square.createSquare(g);
		
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