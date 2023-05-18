package pane;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.Main;

public class TopGamePane extends BorderPane {
	private Main main;
	private Text shotParameter;
	private int maxShot = 8;

	public TopGamePane(Main main) {
		this.main = main;
		this.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, null, null)));
		this.setPrefWidth(800);
		this.setPrefHeight(75);
		this.setPadding(new Insets(15));

		BackButton btn1 = new BackButton(main);
		shotParameter = new Text();
		Button reset = createResetButton();

		this.setShotParameter("0");
		this.setCenter(reset);
		this.setLeft(btn1);
		this.setRight(shotParameter);
	}

	public Button createResetButton() {
		Button reset = new Button();
		reset.setText("reset");
		reset.setOnAction(event -> {
			main.getGameScreen().reset();
			main.getGameScreen().start();
		});
		return reset;

	}

	public Text getShotParameter() {
		return shotParameter;
	}

	public void setShotParameter(String text) {
		this.shotParameter.setText(text + "/" + maxShot);
	}

	public int getMaxShot() {
		return maxShot;
	}

	public void setMaxShot(int maxShot) {
		this.maxShot = maxShot;
	}

}
