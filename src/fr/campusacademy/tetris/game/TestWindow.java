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


public class TestWindow extends BasicGame {
	
	private GameContainer gc;

	public TestWindow(String gamename) {
		super(gamename);
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
		g.setColor(Color.red);
		g.drawRect(100, 100, 50, 50);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		// TODO Auto-generated method stub
		
	}

}
