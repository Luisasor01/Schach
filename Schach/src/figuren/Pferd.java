package figuren;

import feld.Feld;

public class Pferd {
	static int[] possible(int x, int y, int color, Feld field) {
		int[] possibilities = new int[8];
		int counter = 0;
		for(int i = -2;i<=2; i+=4) {
			for(int j = -1;j<=1; j+=2) {
				if(x+i>=0 && x+i<= 7 && y+j>=0 && y+j<=7) {
					possibilities[counter] = (x+i)*10 + y+j;
					counter++;
				}
			}
		}
		for(int i = counter; i<8;i++) {possibilities[i] = -1;}
		return possibilities;
	}
}
