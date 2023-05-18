package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.Main;

public class GameEndScreen extends VBox {
	private Main main;
	private HBox buttonSection;
	private Text titleLabel;
	private boolean isWin;

	public GameEndScreen(Main main, boolean isWin) {
		this.isWin = isWin;
		this.main = main;
		titleLabel = new Text("Adsawdawdawdw");
		titleLabel.setStyle("-fx-font-size: 36px;");
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
			main.getGameScreen().reset();
			main.getGameScreen().start();
		});
		Button home = new Button();
		home.setText("Home");
		home.setOnAction(event -> {
			main.getStage().setScene(main.getWelcomePageScene());
		});
		buttonSection.setSpacing(40);
		buttonSection.getChildren().addAll(reset, home);
		buttonSection.setAlignment(Pos.CENTER);
		chosingScene();
	}

	public void losingScene() {
		titleLabel.setText("YOU LOSE!");
		this.getChildren().addAll(titleLabel, buttonSection);
	}

	public void winningScene() {
		titleLabel.setText("YOU WIN!");
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
