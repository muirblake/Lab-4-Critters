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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


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
			Label critName = new Label("Critter Name (e.g. Algae):");
			grid.add(critName, 0, 0);
			TextField critNameField = new TextField();
			//row++;
			grid.add(critNameField, 1, 0);
			
			// Add Field for No. of Critters
			Label numCrits = new Label("No of critters:");
			grid.add(numCrits, 0, 1);
			TextField critNumField = new TextField();
			//row++;
			grid.add(critNumField, 1, 1);
			
			// Add Button to add Critters.
			Button addBtn = new Button("Add critters");
			HBox hbAddBtn = new HBox(10);
			hbAddBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbAddBtn.getChildren().add(addBtn);
			grid.add(hbAddBtn, 1, 3);
			
			// Action when Add Critters Button is pressed.
			final Text actionTarget = new Text();
			grid.add(actionTarget, 1, 5);
			
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
					String numString = critNumField.getText();
					//TODO: Call Critter.makeCritter as many times as requested.		
					actionTarget.setFill(Color.FIREBRICK);
					actionTarget.setText("TODO: confirmation msg");	
					Critter.displayWorld(); // Optional
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

