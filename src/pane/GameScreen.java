package pane;

import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.GameLogic;
import main.Main;
import sharedObject.RenderableHolder;

public class GameScreen {
	private int shotCounter;
	private GameLogic gameLogic;
	private GolfCourse golfCourse;
	private RootPane rootPane;
	private Scene gameScene;
	private Stage stage;
	private Main main;
	private AnimationTimer animation;

	public GameScreen(Main main, Stage stage) {
		shotCounter = 0 ;
		this.main = main;
		this.stage = stage;
		golfCourse = new GolfCourse();
		rootPane = new RootPane(golfCourse, main);
		gameScene = new Scene(rootPane, 800, 640);
		golfCourse.requestFocus();
		gameLogic = new GameLogic(main);
		animation = new AnimationTimer() {
			public void handle(long now) {
				gameLogic.logicUpdate();
				golfCourse.paintComponent();
				RenderableHolder.getInstance().update();
				InputUtility.updateInputState();
			}
		};
	}

	public void start() {
		animation.start();
		stage.setScene(gameScene);
	}

	public int getShotCounter() {
		return shotCounter;
	}

	public void setShotCounter(int shotCounter) {
		this.shotCounter = shotCounter;
	}

	public void reset() {
		animation.stop();
		RenderableHolder.getInstance().getEntities().clear();
		gameLogic = new GameLogic(main);
		golfCourse = new GolfCourse();
		rootPane = new RootPane(golfCourse, main);
		gameScene = new Scene(rootPane, 800, 640);
	}
}
