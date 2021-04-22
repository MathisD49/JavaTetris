package fr.campusacademy.tetris.launcher;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import fr.campusacademy.tetris.game.SimpleSlickGame;
import fr.campusacademy.tetris.game.TestWindow;

public class Launcher {
	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Tetris"));
			appgc.setDisplayMode(700, 900, false);
			appgc.setTargetFrameRate(4);
			Input.disableControllers();
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
