package fr.campusacademy.tetris.game;

import org.newdawn.slick.Graphics;

public class TypeArrayList{
	// ici mettre des attributes de tous les types de tetriminos
	// creer des constructeurs overload avec tous les types
	// mettre peut être getter setter etc... (aller voir le lien du site)
	// ensuite mettre cette class en type de l'arraylist de simpleslickgame et add un new object dedans à chaque fois
	
	// mettre tous les tetriminos dedans
	// add un tetriminos dans le code principal
	// quand on veut changer on remove puis on add
	// utiliser des nombres pour faire spawn une nouvelle pièce
	
	private LineTetriminos myTetriminosI;
	private TetriminosT myTetriminosT;
	private TetriminosL myTetriminosL;
	private TetriminosJ myTetriminosJ;
	private TetriminosS myTetriminosS;
	private TetriminosZ myTetriminosZ;
	private TetriminosO myTetriminosO;
	
	
	public TypeArrayList(double random) {
		if(random >= 0 && random <= 0.14) {
			this.myTetriminosT = new TetriminosT();
		} else if (random > 0.14 && random <= 0.28){
			this.myTetriminosI = new LineTetriminos();
		} else if (random > 0.28 && random <= 0.42){
			this.myTetriminosL = new TetriminosL();
		} else if (random > 0.42 && random <= 0.56){
			this.myTetriminosJ = new TetriminosJ();
		} else if (random > 0.56 && random <= 0.70){
			this.myTetriminosZ = new TetriminosZ();
		} else if (random > 0.70 && random <= 0.84){
			this.myTetriminosS= new TetriminosS();
		} else {
			this.myTetriminosO = new TetriminosO();
		}
	}
	
	


	public LineTetriminos getMyTetriminosI() {
		return myTetriminosI;
	}


	public TetriminosT getMyTetriminosT() {
		return myTetriminosT;
	}


	public TetriminosL getMyTetriminosL() {
		return myTetriminosL;
	}


	public TetriminosJ getMyTetriminosJ() {
		return myTetriminosJ;
	}


	public TetriminosS getMyTetriminosS() {
		return myTetriminosS;
	}


	public TetriminosZ getMyTetriminosZ() {
		return myTetriminosZ;
	}


	public TetriminosO getMyTetriminosO() {
		return myTetriminosO;
	}
	
	public Tetriminos[] getBlocks(double random) {
		//return this.getBlocks();
		if(random >= 0 && random <= 0.14) {
			return myTetriminosT.getBlocks();
		} else if (random > 0.14 && random <= 0.28){
			return myTetriminosI.getBlocks();
		} else if (random > 0.28 && random <= 0.42){
			return myTetriminosL.getBlocks();
		} else if (random > 0.42 && random <= 0.56){
			return myTetriminosJ.getBlocks();
		} else if (random > 0.56 && random <= 0.70){
			return myTetriminosZ.getBlocks();
		} else if (random > 0.70 && random <= 0.84){
			return myTetriminosS.getBlocks();
		} else {
			return myTetriminosO.getBlocks();
		}
	}
	
	public boolean isMovable(double random) {
		//return this.isMovable();
		if(random >= 0 && random <= 0.14) {
			return myTetriminosT.isMovable();
		} else if (random > 0.14 && random <= 0.28){
			return myTetriminosI.isMovable();
		} else if (random > 0.28 && random <= 0.42){
			return myTetriminosL.isMovable();
		} else if (random > 0.42 && random <= 0.56){
			return myTetriminosJ.isMovable();
		} else if (random > 0.56 && random <= 0.70){
			return myTetriminosZ.isMovable();
		} else if (random > 0.70 && random <= 0.84){
			return myTetriminosS.isMovable();
		} else {
			return myTetriminosO.isMovable();
		}
	}
	
	public void setMovable(boolean isMovable, double random) {
		//this.setMovable(isMovable);
		if(random >= 0 && random <= 0.14) {
			myTetriminosT.setMovable(isMovable);
		} else if (random > 0.14 && random <= 0.28){
			myTetriminosI.setMovable(isMovable);
		} else if (random > 0.28 && random <= 0.42){
			myTetriminosL.setMovable(isMovable);
		} else if (random > 0.42 && random <= 0.56){
			myTetriminosJ.setMovable(isMovable);
		} else if (random > 0.56 && random <= 0.70){
			myTetriminosZ.setMovable(isMovable);
		} else if (random > 0.70 && random <= 0.84){
			myTetriminosS.setMovable(isMovable);
		} else {
			myTetriminosO.setMovable(isMovable);
		}
	}
	
	public void goDown(double random) {
		//this.goDown();
		if(random >= 0 && random <= 0.14) {
			myTetriminosT.goDown();
		} else if (random > 0.14 && random <= 0.28){
			myTetriminosI.goDown();
		} else if (random > 0.28 && random <= 0.42){
			myTetriminosL.goDown();
		} else if (random > 0.42 && random <= 0.56){
			myTetriminosJ.goDown();
		} else if (random > 0.56 && random <= 0.70){
			myTetriminosZ.goDown();
		} else if (random > 0.70 && random <= 0.84){
			myTetriminosS.goDown();
		} else {
			myTetriminosO.goDown();
		}
	}
	
	public void goLeft(double random) {
		//this.goLeft();
		if(random >= 0 && random <= 0.14) {
			myTetriminosT.goLeft();
		} else if (random > 0.14 && random <= 0.28){
			myTetriminosI.goLeft();
		} else if (random > 0.28 && random <= 0.42){
			myTetriminosL.goLeft();
		} else if (random > 0.42 && random <= 0.56){
			myTetriminosJ.goLeft();
		} else if (random > 0.56 && random <= 0.70){
			myTetriminosZ.goLeft();
		} else if (random > 0.70 && random <= 0.84){
			myTetriminosS.goLeft();
		} else {
			myTetriminosO.goLeft();
		}
	}
	
	public void goRight(double random) {
		//this.goRight();
		if(random >= 0 && random <= 0.14) {
			myTetriminosT.goRight();
		} else if (random > 0.14 && random <= 0.28){
			myTetriminosI.goRight();
		} else if (random > 0.28 && random <= 0.42){
			myTetriminosL.goRight();
		} else if (random > 0.42 && random <= 0.56){
			myTetriminosJ.goRight();
		} else if (random > 0.56 && random <= 0.70){
			myTetriminosZ.goRight();
		} else if (random > 0.70 && random <= 0.84){
			myTetriminosS.goRight();
		} else {
			myTetriminosO.goRight();
		}
	}
	
	public int getIndexRotate(double random) {
		//return this.getIndexRotate();
		if(random >= 0 && random <= 0.14) {
			return myTetriminosT.getIndexRotate();
		} else if (random > 0.14 && random <= 0.28){
			return myTetriminosI.getIndexRotate();
		} else if (random > 0.28 && random <= 0.42){
			return myTetriminosL.getIndexRotate();
		} else if (random > 0.42 && random <= 0.56){
			return myTetriminosJ.getIndexRotate();
		} else if (random > 0.56 && random <= 0.70){
			return myTetriminosZ.getIndexRotate();
		} else if (random > 0.70 && random <= 0.84){
			return myTetriminosS.getIndexRotate();
		} else {
			return myTetriminosO.getIndexRotate();
		}
	}

	public void setIndexRotate(int indexRotate, double random) {
		//this.setIndexRotate(indexRotate);
		if(random >= 0 && random <= 0.14) {
			myTetriminosT.setIndexRotate(indexRotate);
		} else if (random > 0.14 && random <= 0.28){
			myTetriminosI.setIndexRotate(indexRotate);
		} else if (random > 0.28 && random <= 0.42){
			myTetriminosL.setIndexRotate(indexRotate);
		} else if (random > 0.42 && random <= 0.56){
			myTetriminosJ.setIndexRotate(indexRotate);
		} else if (random > 0.56 && random <= 0.70){
			myTetriminosZ.setIndexRotate(indexRotate);
		} else if (random > 0.70 && random <= 0.84){
			myTetriminosS.setIndexRotate(indexRotate);
		} else {
			myTetriminosO.setIndexRotate(indexRotate);
		}
	}
	
	public void rotateLeft(int position, double random) {
		//this.rotateLeft(position);
		if(random >= 0 && random <= 0.14) {
			myTetriminosT.rotateLeft(position);
		} else if (random > 0.14 && random <= 0.28){
			myTetriminosI.rotateLeft(position);
		} else if (random > 0.28 && random <= 0.42){
			myTetriminosL.rotateLeft(position);
		} else if (random > 0.42 && random <= 0.56){
			myTetriminosJ.rotateLeft(position);
		} else if (random > 0.56 && random <= 0.70){
			myTetriminosZ.rotateLeft(position);
		} else if (random > 0.70 && random <= 0.84){
			myTetriminosS.rotateLeft(position);
		} else {
			myTetriminosO.rotateLeft(position);
		}
	}
	
	public void rotateRight(int position, double random) {			
		//this.rotateRight(position);
		if(random >= 0 && random <= 0.14) {
			myTetriminosT.rotateRight(position);
		} else if (random > 0.14 && random <= 0.28){
			myTetriminosI.rotateRight(position);
		} else if (random > 0.28 && random <= 0.42){
			myTetriminosL.rotateRight(position);
		} else if (random > 0.42 && random <= 0.56){
			myTetriminosJ.rotateRight(position);
		} else if (random > 0.56 && random <= 0.70){
			myTetriminosZ.rotateRight(position);
		} else if (random > 0.70 && random <= 0.84){
			myTetriminosS.rotateRight(position);
		} else {
			myTetriminosO.rotateRight(position);
		}
		
	}
	
	public void createItem(Graphics g, double random) {
		//this.createItem(g);
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




	@Override
	public String toString() {
		return "TypeArrayList [myTetriminosT=" + myTetriminosT + "]";
	}

	
	
}


// si pas possible on va faire en sorte d'overload les methodes avec un paramètre nombre pour faire le truc des if
