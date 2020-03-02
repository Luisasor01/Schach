package figuren;

import feld.Feld;

public class Bauer {
	static int[] possible(int x, int y, int color, Feld field) {
		int[] possibilities = new int[4];
		int counter = 0;
		if(field.getPositions(x+color, y) == null) {
			possibilities[counter] = ((x+color)*10 + y);
			counter++;
			if(field.getPositions(x+2*color, y) == null) {
				possibilities[counter] = ((x+2*color)*10 + y);
				counter++;
			}
		}
		if(y>=1 && field.getPositions(x+color, y-1) != null) {
			if(field.getPositions(x+color, y-1).color != color) {
				possibilities[counter] = ((x+color)*10+ y-1);
				counter++;
			}
		}
		if(y<=6 && field.getPositions(x+color, y+1) != null) {
			if(field.getPositions(x+color, y+1).color != color) {
				possibilities[counter] = ((x+color)*10+ y+1);
				counter++;
			}
		}
		for(int i = counter; i<4;i++) {possibilities[i] = -1;}
		return possibilities;
	}
}
