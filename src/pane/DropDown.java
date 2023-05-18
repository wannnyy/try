package pane;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import main.Main;

public class DropDown extends HBox {
	public DropDown(Main main) {
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll("Option 1", "Option 2", "Option 3");
		choiceBox.setValue("Option 1");
		main.setSelectedMap("Option 1");

		// Create a Button
		Button dropDownButton = new Button("Select");

		// Event handler for the button click
		dropDownButton.setOnAction(event -> {
			String selectedOption = choiceBox.getValue();
			System.out.println("Selected Option: " + selectedOption);
			if (selectedOption != null) {
				main.setSelectedMap(selectedOption);
				main.getGameScreen().reset();
			} else {
				// Play error sound I guess
			}
		});

		this.getChildren().addAll(choiceBox, dropDownButton);
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
	}

	public HBox getDropDown() {
		return this;
	}
}
