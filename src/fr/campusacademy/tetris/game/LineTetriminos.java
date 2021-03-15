//package fr.campusacademy.tetris.game;
//
//import org.newdawn.slick.Color;
//import org.newdawn.slick.Graphics;
//
//public class LineTetriminos extends Tetriminos {
//	
//	private Color color;
//	
//	private Tetriminos bloc1 = new Tetriminos(Color.green, 50, 50, 50, 0);
//	private Tetriminos bloc2 = new Tetriminos(Color.green, 50, 50, 100, 0);
//	private Tetriminos bloc3 = new Tetriminos(Color.green, 50, 50, 150, 0);
//	private Tetriminos bloc4 = new Tetriminos(Color.green, 50, 50, 200, 0);
//	
//	public LineTetriminos() {
//		
//	}
//	
//	public void lineCreate(Graphics g) {
//		bloc1.createSquare(g);
//		bloc2.createSquare(g);
//		bloc3.createSquare(g);
//		bloc4.createSquare(g);
//	}
//	
//	public void goDown(Tetriminos highestBlock) {
//		
//	}
//	
//	public void goRight() {
//		
//	}
//	
//	public void goLeft() {
//		
//	}
//	
//	
//	public Color getColor() {
//		return color;
//	}
//
//	public void setColor(Color color) {
//		this.color = color;
//	}
//
//	public Tetriminos getBloc1() {
//		return bloc1;
//	}
//
//	public void setBloc1(Tetriminos bloc1) {
//		this.bloc1 = bloc1;
//	}
//
//	public Tetriminos getBloc2() {
//		return bloc2;
//	}
//
//	public void setBloc2(Tetriminos bloc2) {
//		this.bloc2 = bloc2;
//	}
//
//	public Tetriminos getBloc3() {
//		return bloc3;
//	}
//
//	public void setBloc3(Tetriminos bloc3) {
//		this.bloc3 = bloc3;
//	}
//
//	public Tetriminos getBloc4() {
//		return bloc4;
//	}
//
//	public void setBloc4(Tetriminos bloc4) {
//		this.bloc4 = bloc4;
//	}
//
//	@Override
//	public String toString() {
//		return "LineTetriminos [color=" + color + ", bloc1=" + bloc1 + ", bloc2=" + bloc2 + ", bloc3=" + bloc3
//				+ ", bloc4=" + bloc4 + "]";
//	}
//	
//	
//	
//	
//}
