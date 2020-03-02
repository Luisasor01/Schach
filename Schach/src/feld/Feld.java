package feld;

import figuren.Figur;

public class Feld {
	private Figur[][] x;
	public Feld(int spiel) {
		if(spiel == 1) {
			x = new Figur[8][8];
			for(int i = 0; i<8;i++) {
				for(int j = 0; j<8;j++) {
					switch (i*10+j) {
					case 00: case 07:
						x[i][j] = new Figur(1,1,i,j);
						break;
					case 01: case 06:
						x[i][j] = new Figur(2,1,i,j);
						break;
					case 02: case 05:
						x[i][j] = new Figur(3,1,i,j);
						break;
					case 03: 
						x[i][j] = new Figur(4,1,i,j);
						break;
					case 04:
						x[i][j] = new Figur(5,1,i,j);
						break;
					case 10: case 11: case 12: case 13: case 14: case 15: case 16: case 17:
						x[i][j] = new Figur(6,1,i,j);
						break;
					case 70: case 77:
						x[i][j] = new Figur(1,-1,i,j);
						break;
					case 71: case 76:
						x[i][j] = new Figur(2,-1,i,j);
						break;
					case 72: case 75:
						x[i][j] = new Figur(3,-1,i,j);
						break;
					case 73: 
						x[i][j] = new Figur(4,-1,i,j);
						break;
					case 74:
						x[i][j] = new Figur(5,-1,i,j);
						break;
					case 60: case 61: case 62: case 63: case 64: case 65: case 66: case 67:
						x[i][j] = new Figur(6,-1,i,j);
						break;
					}
				}
			}
		}
	}
	public Figur getPositions(int x, int y) {
		return this.x[x][y];
	}
	public void moved(int x, int y, int oldx, int oldy, Figur figur) {
		Figur alteFigur = this.x[x][y];
		this.x[x][y] = figur;
		this.x[oldx][oldy] = null;
		if(alteFigur != null) {
			//Do something
		}
	}
}
