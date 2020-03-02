package figuren;

import feld.Feld;

public class Figur {
	int color;
	int x;
	int y;
	int figur;
	
	public Figur(int figur, int color, int x, int y) {
		this.x = x;
		this.y = y;
		this.figur = figur;
		this.color = color;
	}
	public int[] possible(Feld field) {
		switch (figur) {
		case 1:
			return Turm.possible(x, y, color, field);
		case 2:
			return Pferd.possible(x, y, color, field);
		case 3:
			return Renner.possible(x, y, color, field);
		case 4:
			return Konig.possibile(x, y, color, field);
		case 5:
			return Konigin.possibile(x, y, color, field);
		case 6:
			return Bauer.possible(x, y, color, field);
			default:
				return null;
		}
	}
	public int getFigur() {
		return figur;
	}
}
