package fr.campusacademy.tetris.game;

import org.newdawn.slick.Graphics;

public class PreviewTetriminos {
	
	private LineTetriminos myTetriminosI;
	private TetriminosT myTetriminosT;
	private TetriminosL myTetriminosL;
	private TetriminosJ myTetriminosJ;
	private TetriminosS myTetriminosS;
	private TetriminosZ myTetriminosZ;
	private TetriminosO myTetriminosO;
	
	public PreviewTetriminos(double random) {
		if(random >= 0 && random <= 0.14) {
			this.myTetriminosT = new TetriminosT(525, 800, 575, 800, 575, 750, 625, 800);
		} else if (random > 0.14 && random <= 0.28){
			this.myTetriminosI = new LineTetriminos(500, 775, 550, 775, 600, 775, 650, 775);
		} else if (random > 0.28 && random <= 0.42){
			this.myTetriminosL = new TetriminosL(525, 750, 525, 800, 575, 800, 625, 800);
		} else if (random > 0.42 && random <= 0.56){
			this.myTetriminosJ = new TetriminosJ(525, 800, 575, 800, 625, 800, 625, 750);
		} else if (random > 0.56 && random <= 0.70){
			this.myTetriminosZ = new TetriminosZ(525, 750, 575, 750, 575, 800, 625, 800);
		} else if (random > 0.70 && random <= 0.84){
			this.myTetriminosS= new TetriminosS(525, 800, 575, 800, 575, 750, 625, 750);
		} else {
			this.myTetriminosO = new TetriminosO(550, 750, 600, 750, 550, 800, 600, 800);
		}
	}
	
	public void createItem(Graphics g, double random) {
		if(random >= 0 && random <= 0.14) {
			myTetriminosT.createItem(g);
		} else if (random > 0.14 && random <= 0.28){
			myTetriminosI.createItem(g);
		} else if (random > 0.28 && random <= 0.42){
			myTetriminosL.createItem(g);
		} else if (random > 0.42 && random <= 0.56){
			myTetriminosJ.createItem(g);
		} else if (random > 0.56 && random <= 0.70){
			myTetriminosZ.createItem(g);
		} else if (random > 0.70 && random <= 0.84){
			myTetriminosS.createItem(g);
		} else {
			myTetriminosO.createItem(g);
		}
	}
}
