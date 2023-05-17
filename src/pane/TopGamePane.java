package pane;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Main;

public class TopGamePane extends BorderPane {
	public TopGamePane(Main main) {
		this.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, null, null)));
		this.setPrefWidth(800);
		this.setPrefHeight(75);
		this.setPadding(new Insets(15));
		BackButton btn1 = new BackButton(main);
//		this.getChildren().add(btn1);
		Text shotCount = new Text("0");
//		this.getChildren().add(shotCount);
		this.setLeft(btn1);
		this.setRight(shotCount);
	}
	
}
