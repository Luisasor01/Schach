package figuren;

import feld.Feld;

public class Konigin {
	static int[] possibile(int x, int y, int color, Feld field) {
		int[] possibilities = new int[28];
		int[] turm = Turm.possible(x, y, color, field);
		int[] renner = Renner.possible(x, y, color, field);
		int counter = 0;
		int j = 0;
		while(turm[counter] >=0) {
			possibilities[counter] = turm[counter];
			counter++;
		}
		while(renner[j] >= 0) {
			possibilities[counter+j] = renner[j];
			j++;
		}
		for(int i = counter+j; i<28;i++) {possibilities[i] = -1;}
		return possibilities;
	}
}
