package fr.campusacademy.tetris.game;

public class Score {
	private int point;
	private int level;
	private int nbLign;

	public Score() {
		point = 0;
		level = 1;
		nbLign = 0;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getNiveau() {
		return level;
	}

	public void setNiveau(int level) {
		this.level = level;
	}

	public int getNbLigne() {
		return nbLign;
	}

	public void setNbLigne(int nbLign) {
		this.nbLign = nbLign;
	}

	public void calculerScore(int nblignsup) {
		nbLign += nblignsup;
		if (nbLign % 10 == 0 && nbLign != 0) {
			level++;
			nbLign = 0;
		}

		switch (nblignsup) {
		case 1:
			point += 40 * level;
			break;
		case 2:
			point += 100 * level;
			break;
		case 3:
			point += 300 * level;
			break;
		case 4:
			point += 1200 * level;
			break;
		}

	}

	@Override
	public String toString() {
		return "nbligne : " + nbLigne + "\n" + "points : " + point + "\nniveau : " + niveau + "\n\n";
	}
}
