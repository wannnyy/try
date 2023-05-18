package pane;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.Main;
import sharedObject.RenderableHolder;

public class WelcomePage extends StackPane {
	private Button startButton;
	private Button exitButton;
	private DropDown dropDown;
	private Main myMain;

	public WelcomePage(Stage stage, Main main) {
		ImageView backgroundImageView = new ImageView(RenderableHolder.backgroundImage);

		// Set the size of the ImageView to match the welcomePage
		backgroundImageView.fitWidthProperty().bind(this.widthProperty());
		backgroundImageView.fitHeightProperty().bind(this.heightProperty());
		getChildren().add(backgroundImageView);

		this.myMain = main;
		Label titleLabel = new Label("My Mini Golf Game");
		titleLabel.getStyleClass().add("text-title");

		// Create a button to start the game
		startButton = new Button("Start Game");
		startButton.getStyleClass().add("button-start");
		startButton.setOnAction(event -> {
			RenderableHolder.clickSound.play();
			myMain.getGameScreen().start();
		});

		// Create a button to exit the game
		exitButton = new Button("Exit Game");
		exitButton.getStyleClass().add("button-exit");
		exitButton.setOnAction(event -> {
			RenderableHolder.clickSound.play();
			Platform.exit();
		});

		dropDown = new DropDown(main);

		// Add the components to the pane
		setPadding(new Insets(40));
		setAlignment(Pos.CENTER);
		VBox buttonsBox = new VBox(10);
		buttonsBox.setSpacing(40);
		buttonsBox.getChildren().addAll(titleLabel, startButton, exitButton, dropDown);
		buttonsBox.setAlignment(Pos.CENTER);

		// Add the VBox to the StackPane
		getChildren().add(buttonsBox);
	}

	// Getter methods for the start and exit buttons

	public Button getStartButton() {
		return startButton;
	}

	public Button getExitButton() {
		return exitButton;
	}
}