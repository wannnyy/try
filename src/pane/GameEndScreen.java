package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.Main;
import sharedObject.RenderableHolder;

public class GameEndScreen extends VBox {
	private Main main;
	private HBox buttonSection;
	private Label titleLabel;
	private boolean isWin;

	public GameEndScreen(Main main, boolean isWin) {
		this.isWin = isWin;
		this.main = main;
		this.getStyleClass().add("ending");
		titleLabel = new Label();
		titleLabel.getStyleClass().add("text-title");
		createButtonSection();
		setSpacing(20);
		setPadding(new Insets(40));
		setAlignment(Pos.CENTER);
	}

	public void createButtonSection() {
		buttonSection = new HBox();
		Button reset = new Button();
		reset.setText("Play Again");
		reset.setOnAction(event -> {
			RenderableHolder.clickSound.play();
			main.getGameScreen().reset();
			main.getGameScreen().start();
		});
		reset.getStyleClass().add("ending-reset");


		Button home = new Button();
		home.setText("Home");
		home.setOnAction(event -> {
			main.getStage().setScene(main.getWelcomePageScene());
			RenderableHolder.clickSound.play();
		});
		home.getStyleClass().add("ending-home");

		
		buttonSection.setSpacing(40);
		buttonSection.getChildren().addAll(reset, home);
		buttonSection.setAlignment(Pos.CENTER);

		chosingScene();
	}

	public void losingScene() {
		titleLabel.setText("YOU LOSE!");
		RenderableHolder.failSound.play();
		this.getChildren().addAll(titleLabel, buttonSection);
	}

	public void winningScene() {
		titleLabel.setText("YOU WIN!");
		RenderableHolder.successSound.play();
		this.getChildren().addAll(titleLabel, buttonSection);
	}

	public void chosingScene() {
		if (isWin) {
			winningScene();
		} else {
			losingScene();
		}
	}

}
