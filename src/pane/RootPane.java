package pane;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Main;

public class RootPane extends VBox {
	private static TopGamePane topGamePane;
	private static GolfCourse golfCourse ;

	public RootPane(GolfCourse golfcourse, Main main) {
		topGamePane = new TopGamePane(main);
		this.golfCourse = golfcourse ;
		this.getChildren().add(topGamePane);
		this.getChildren().add(golfCourse);
	}
}
