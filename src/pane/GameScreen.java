package pane;

import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.GameLogic;
import main.Main;
import sharedObject.RenderableHolder;

public class GameScreen {
	private GameLogic gameLogic;
	private GolfCourse golfCourse;
	private TopGamePane topGamePane;
	private Scene gameScene;
	private Stage stage;
	private Main main;
	private AnimationTimer animation;

	public GameScreen(Main main, Stage stage) {
		this.main = main;
		this.stage = stage;
		golfCourse = new GolfCourse();
		gameLogic = new GameLogic(main);
		gameScene = new Scene(createPane(golfCourse, main), 800, 640);
		gameScene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

		animation = new AnimationTimer() {
			public void handle(long now) {
				gameLogic.logicUpdate();
				golfCourse.paintComponent();
				RenderableHolder.getInstance().update();
				InputUtility.updateInputState();
				topGamePane.setShotParameter(gameLogic.getShotCounter() + "");
			}
		};
	}

	public VBox createPane(GolfCourse golfCourse, Main main) {
		VBox gamePane = new VBox();
		topGamePane = new TopGamePane(main);
		topGamePane.setMaxShot(gameLogic.getMaxShot());
		topGamePane.setShotParameter("0");
		gamePane.getChildren().addAll(topGamePane, golfCourse);
		return gamePane;
	}

	public void start() {
		animation.start();
		stage.setScene(gameScene);
	}

	public void reset() {
		animation.stop();
		RenderableHolder.getInstance().getEntities().clear();
		gameLogic = new GameLogic(main);
		golfCourse = new GolfCourse();
		gameScene = new Scene(createPane(golfCourse, main), 800, 640);
		gameScene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
	}
}
