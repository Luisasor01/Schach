package figuren;

import feld.Feld;

public class Turm {
	static int[] possible(int x, int y, int color, Feld field) {
		int[] possibilities = new int[14];
		int counter = 0;
		for(int i = 1; i <= 6; i ++) {
			if(x+i>=0 && x+i<=7) {
				if(field.getPositions(x+i, y) == null) {
					possibilities[counter] = ((x+i)*10 + y);
					counter++;
				} else {
					break;
				}
			}
		}
		for(int i = 1; i <= 6; i ++) {
			if(x-i>=0 && x-i<=7) {
				if(field.getPositions(x-i, y) == null) {
					possibilities[counter] = ((x-i)*10 + y);
					counter++;
				} else {
					break;
				}
			}
		}
		for(int i = 1; i <= 6; i ++) {
			if(y+i>=0 && y+i<=7) {
				if(field.getPositions(x, y+i) == null) {
					possibilities[counter] = (x*10 + y+i);
					counter++;
				} else {
					break;
				}
			}
		}
		for(int i = 1; i <= 6; i ++) {
			if(y-i>=0 && y-i<=7) {
				if(field.getPositions(x, y-i) == null) {
					possibilities[counter] = (x*10 + y-i);
					counter++;
				} else {
					break;
				}
			}
		}
		for(int i = counter; i<14;i++) {possibilities[i] = -1;}
		return possibilities;
	}
}
