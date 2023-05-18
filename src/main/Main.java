package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pane.GameScreen;
import pane.WelcomePage;

public class Main extends Application {
	private String selectedMap;
	private Scene welcomePageScene;
	private Stage stage;
	private GameScreen gameScreen;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		WelcomePage welcomePage = new WelcomePage(stage, this);
		welcomePageScene = new Scene(welcomePage, 800, 640);
		gameScreen = new GameScreen(this, stage);

		stage.setScene(welcomePageScene);
		stage.setTitle("MiniGolf");
		stage.setResizable(false);
		stage.show();
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public String getSelectedMap() {
		return selectedMap;
	}

	public void setSelectedMap(String selectedMap) {
		this.selectedMap = selectedMap;
	}

	public Scene getWelcomePageScene() {
		return this.welcomePageScene;
	}

	public Stage getStage() {
		return this.stage;
	}

}