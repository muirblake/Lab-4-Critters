/* CRITTERS <MyClass.java>
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Blake Muir
 * Bmm2897
 * <Student1 5-digit Unique No.>
 * James Tsao
 * jt28593
 * <Student2 5-digit Unique No.>
 * Slip days used: 1
 * Fall 2015
 */

package project4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Slider;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Java FX Critters");
			
			// Add a grid pane to lay out the buttons and text fields.
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.TOP_LEFT);
			grid.setHgap(7);
			grid.setVgap(7);
			grid.setPadding(new Insets(25, 25, 25, 25));
			
			
			// Add Field for Critter type.
			Label critName = new Label("Critter Name:");
			grid.add(critName, 0, 0);
			TextField critNameField = new TextField();
			//row++;
			grid.add(critNameField, 1, 0);
			
			// Add Field for No. of Critters
			Label numCrits = new Label("No of critters:");
			grid.add(numCrits, 0, 1);
			Spinner critNumField = new Spinner(0,99999999,0, 5);
			critNumField.setEditable(true);
			grid.add(critNumField, 1, 1);
			
			// Add Button to add Critters.
			Button addBtn = new Button("Add critters");
			HBox hbAddBtn = new HBox(10);
			hbAddBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbAddBtn.getChildren().add(addBtn);
			grid.add(hbAddBtn, 1, 3);
			
			Button statsBtn = new Button("Stats");
			HBox hbStatsBtn = new HBox(10);
			hbStatsBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbStatsBtn.getChildren().add(statsBtn);
			grid.add(hbStatsBtn, 2, 0);
			
			final Text actionTarget = new Text();
			grid.add(actionTarget, 1, 4);
			
			Label numSteps = new Label("No of steps:");
			grid.add(numSteps, 0, 7);
			Spinner numStepsField = new Spinner(0,999999999,0, 10);
			numStepsField.setEditable(true);
			grid.add(numStepsField, 1, 7);
			
			// Add Button to add Critters.
			Button stepGo = new Button("Take steps");
			HBox stepGoBox = new HBox(10);
			stepGoBox.setAlignment(Pos.BOTTOM_RIGHT);
			stepGoBox.getChildren().add(stepGo);
			grid.add(stepGoBox, 1, 8);
			
			Label seedLabel = new Label("Set seed:");
			grid.add(seedLabel, 0, 11);
			TextField seedField = new TextField();
			grid.add(seedField, 1, 11);
			
			Label animationLabel = new Label("Animation speed:");
			grid.add(animationLabel, 0, 9);
			Slider animationSlider = new Slider(0,100,1);
			animationSlider.setShowTickLabels(true);
			animationSlider.setShowTickMarks(true);
			grid.add(animationSlider, 1, 9);
			Button animateButton = new Button("Go");
			HBox hbanimateButton = new HBox(10);
			hbanimateButton.setAlignment(Pos.BOTTOM_RIGHT);
			hbanimateButton.getChildren().add(animateButton);
			grid.add(hbanimateButton, 2, 9);
			Button stopButton = new Button("Stop");
			HBox hbstopButton = new HBox(10);
			hbstopButton.setAlignment(Pos.BOTTOM_RIGHT);
			hbstopButton.getChildren().add(stopButton);
			grid.add(hbstopButton, 3, 9);
			
			//grid.setGridLinesVisible(true);
			Scene scene = new Scene(grid, 1366, 760);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			// Action when add critters button is pressed. Call makeCritter.
			// Uses something called an anonymous class of type EventHandler<ActionEvent>, which is a class that is
			// defined inline, in the curly braces.
			addBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					String name = critNameField.getText();
					Integer numString = (Integer) critNumField.getValue();
					//TODO: Call Critter.makeCritter as many times as requested.		
					actionTarget.setFill(Color.FIREBRICK);
					actionTarget.setText(String.format("%d %s critters made.", numString, name));	
					//Critter.displayWorld(); // Optional
				}			
			});
			
			
			

		} catch(Exception e) {
			e.printStackTrace();		
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

