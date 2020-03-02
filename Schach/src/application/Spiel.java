package application;

import feld.Feld;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Spiel extends Application {
	GridPane grid;
	BorderPane bp;
	static Feld feld;
	static Button[][] felder;
	static int x;
	static int y;
	
	@Override
	public void start(Stage stage) {
		feld = new Feld(1);
		x = 2;
		y = 4;
		if(feld.getPositions(x, y) != null) {
			System.out.println(feld.getPositions(x, y).getFigur());
		} else {
			System.out.println("leeres Feld");
		}
		stage.setTitle("Schach");
		initialize(stage);
		ordne(stage);
		setListener();
	}

	private void setListener() {
		for(Button[] x : felder) {
			for(Button y : x) {
				y.setOnAction((ev) -> auswahlen(y, y.getAccessibleText()));
			}
		}
	}

	private void ordne(Stage stage) {
		grid = new GridPane();
		for(int i = 0; i <=7; i++) {
			for(int j = 0; j <=7; j++) {
				grid.add(felder[i][j], i, j);
			}
		}
		bp = new BorderPane();
		bp.setCenter(grid);
		Scene scene = new Scene(bp,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		System.out.println(1);
		stage.setScene(scene);
		stage.show();
	}

	private void initialize(Stage stage) {
		felder = new Button[8][8];
		for(int i = 0; i <=7; i++) {
			for(int j = 0; j <=7; j++) {
				felder[i][j] = new Button();
				felder[i][j].setAccessibleText(i+""+j);
				if((i+j)%2 == 0) {
					felder[i][j].setStyle("-fx-background-color: " + "white");
				} else {
					felder[i][j].setStyle("-fx-background-color: " + "black");
				}
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
		System.out.println(2);
	}
	
	public static void auswahlen(Button button, String xy) {
		int x = Integer.parseInt(xy.substring(0, 1));
		int y = Integer.parseInt(xy.substring(1, 2));
		if(feld.getPositions(x, y) != null) {
			int[] p = feld.getPositions(x, y).possible(feld);
			for(int i : p) {
				if(i>=0) {
					felder[i/10][i%10].setStyle("-fx-background-color: " + "yellow");
					felder[i/10][i%10].setOnAction((ev) -> {
						feld.moved(i/10, i%10, x, y, feld.getPositions(x, y));
						resetColors();});
				}
			}
		}
	}

	private static void resetColors() {
		for(int i = 0; i <=7; i++) {
			for(int j = 0; j <=7; j++) {
				if((i+j)%2 == 0) {
					felder[i][j].setStyle("-fx-background-color: " + "white");
				} else {
					felder[i][j].setStyle("-fx-background-color: " + "black");
				}
			}
		}
	}

}
