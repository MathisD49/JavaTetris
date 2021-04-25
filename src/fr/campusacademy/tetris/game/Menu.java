package fr.campusacademy.tetris.game;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Menu extends JFrame implements ActionListener {

	JButton button;

	public Menu() {

		ImageIcon playIcon = new ImageIcon("assets/playbutton.png");
		ImageIcon quitIcon = new ImageIcon("assets/quitbutton.png");
		ImageIcon menuIcon = new ImageIcon("assets/menuicon.png");
		
		// création du bouton "Play"
		JButton playButton = new JButton();
		playButton.setBounds(100, 200, 200, 100);
		playButton.addActionListener(e -> playGame());
		playButton.addActionListener(e -> removeMenu());
		playButton.setFocusable(false);
		playButton.setIcon(playIcon);

		// création du bouton "Exit"
		JButton quitButton = new JButton();
		quitButton.setBounds(400, 200, 200, 100);
		quitButton.addActionListener(e -> System.exit(0));
		quitButton.setFocusable(false);
		quitButton.setIcon(quitIcon);
		
		// mise en place des différents paramètres de la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Tetris Menu");
		this.setLayout(null);
		this.setSize(700, 500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.add(playButton);
		this.add(quitButton);
	}

	// méthode permettant de lancer le jeu
	void playGame() {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Tetris"));
			appgc.setDisplayMode(700, 900, false);
			appgc.setTargetFrameRate(4);
			Input.disableControllers();
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	// permet de fermer la fenetre du menu après avoir lancé le jeu
	void removeMenu() {
		this.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
