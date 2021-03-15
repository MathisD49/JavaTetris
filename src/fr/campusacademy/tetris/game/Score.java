package fr.campusacademy.tetris.game;

public class Score {
	private int point;
	private int level;
	private int nbLine;

	public Score() {
		point = 0;
		level = 1;
		nbLine = 0;
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
		return nbLine;
	}

	public void setNbLigne(int nbLign) {
		this.nbLine = nbLign;
	}

	public void calculerScore(int nbLineDel) {
		nbLine += nbLineDel;
		if (nbLine % 10 == 0 && nbLine != 0) {
			level++;
			nbLine = 0;
		}

		switch (nbLineDel) {
		case 1:
			point += 40 * level + 1;
			break;
		case 2:
			point += 100 * level + 1;
			break;
		case 3:
			point += 300 * level + 1;
			break;
		case 4:
			point += 1200 * level + 1;
			break;
		}

	}

	@Override
	public String toString() {
		return "Ligne : " + nbLine + "\n" + "Points : " + point + "\nNiveau : " + level + "\n\n";
	}
}
