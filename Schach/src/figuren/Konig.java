package figuren;

import feld.Feld;

public class Konig {
	static int[] possibile(int x, int y, int color, Feld field) {
		int[] possibilities = new int[8];
		int counter = 0;
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				if(x+i>=0 && x+i<=7 && y+j>=0 && y+j<=7) {
					if(field.getPositions(x+i, y+j) == null || field.getPositions(x, y).color != color) {
						possibilities[counter] = (x+i)*10+y+j;
						counter++;
					}
				}
			}
		}
		for(int i = counter; i<8;i++) {possibilities[i] = -1;}
		return possibilities;
	}
}
