package pane;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Main;

public class GameEndScreen extends VBox{
	public GameEndScreen(Stage stage,Main main) {
		Text titleLabel = new Text("Game End");
		titleLabel.setStyle("-fx-font-size: 36px;");
	}
}
