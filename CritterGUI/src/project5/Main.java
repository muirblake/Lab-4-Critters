/* CRITTERS <MyClass.java>
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Blake Muir
 * Bmm2897
 * <Student1 5-digit Unique No.>
 * James Tsao
 * jt28593
 * <Student2 5-digit Unique No.>
 * Slip days used: 0
 * Fall 2015
 */

package project5;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Slider;

public class Main extends Application {
	static boolean runAnimation = false;
	Thread aniThread;
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

			// -----------------------------------------------------------
			// Critter adding block.
			// Add Field for Critter type.
			Label critName = new Label("Critter Name:");
			grid.add(critName, 0, 0);
			TextField critNameField = new TextField();
			// row++;
			grid.add(critNameField, 1, 0);

			// Add Field for No. of Critters
			Label numCrits = new Label("No of critters:");
			grid.add(numCrits, 0, 1);
			Spinner critNumField = new Spinner(0, 99999999, 0, 5);
			critNumField.setEditable(true);
			grid.add(critNumField, 1, 1);

			// Add Button to add Critters.
			Button addBtn = new Button("Add critters");
			HBox hbAddBtn = new HBox(10);
			hbAddBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbAddBtn.getChildren().add(addBtn);
			grid.add(hbAddBtn, 1, 3);

			final Text addCritMsg = new Text();
			grid.add(addCritMsg, 1, 4);
			// Action when add critters button is pressed. Call makeCritter.
			// Uses something called an anonymous class of type
			// EventHandler<ActionEvent>, which is a class that is
			// defined inline, in the curly braces.
			addBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					try {
						String name = critNameField.getText();
						Integer numString = (Integer) critNumField.getValue();
						if (numString == 0) {
							addCritMsg.setFill(Color.ROYALBLUE);
							addCritMsg.setText("");
							return;
						}
						for (int i = 0; i < numString; i++) {
							Critter.makeCritter(name);
						}
						addCritMsg.setFill(Color.ROYALBLUE);
						addCritMsg.setText(String.format("%d %s critters made.", numString, name));
						// Critter.displayWorld(); // Optional
					} catch (Exception e) {
						addCritMsg.setFill(Color.FIREBRICK);
						addCritMsg.setText(String.format("%s is not a valid critter!", critNameField.getText()));
					}
				}
			});
			// --------------------------------------------------------
			Button statsBtn = new Button("Stats");
			HBox hbStatsBtn = new HBox(10);
			hbStatsBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbStatsBtn.getChildren().add(statsBtn);
			grid.add(hbStatsBtn, 2, 0);
			final Text statMsg = new Text();
			grid.add(statMsg, 6, 0);
			statsBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					try {
						java.util.List<Critter> critterlist = Critter.getInstances(critNameField.getText());
						Class<?> critclass = Class.forName(critNameField.getText());
						java.lang.reflect.Method rsMethod = critclass.getMethod("runStats", java.util.List.class);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos);
						PrintStream prev = System.out;
						// System.setOut(ps);
						rsMethod.invoke(null, critterlist);
						// System.out.flush();
						// System.setOut(prev);
						statMsg.setFill(Color.ROYALBLUE);
						// statMsg.setText(String.format(baos.toString()));
						statMsg.setText(String.format("Check the console for stats!"));
					} catch (Exception e) {
						statMsg.setFill(Color.FIREBRICK);
						statMsg.setText(String.format("ERROR running stats for %s critter!", critNameField.getText()));
						//e.printStackTrace();
					}
				}
			});

			Label numSteps = new Label("No of steps:");
			grid.add(numSteps, 0, 7);
			Spinner numStepsField = new Spinner(0, 999999999, 0, 1);
			numStepsField.setEditable(true);
			grid.add(numStepsField, 1, 7);
			Button stepGo = new Button("Take steps");
			HBox stepGoBox = new HBox(10);
			stepGoBox.setAlignment(Pos.BOTTOM_RIGHT);
			stepGoBox.getChildren().add(stepGo);
			grid.add(stepGoBox, 1, 8);
			stepGo.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Integer numSteps = (Integer) numStepsField.getValue();
					for (int i = 0; i < numSteps; i++) {
						Critter.worldTimeStep();
					}
					Critter.displayWorld();
				}
			});
			Button onestepGo = new Button("Take 1 step");
			HBox onestepGoBox = new HBox(10);
			onestepGoBox.setAlignment(Pos.BOTTOM_RIGHT);
			onestepGoBox.getChildren().add(onestepGo);
			grid.add(onestepGoBox, 3, 8);
			onestepGo.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Critter.worldTimeStep();
					Critter.displayWorld();
				}
			});
			Button hundredstepGo = new Button("Take 100 steps");
			HBox hundredstepGoBox = new HBox(10);
			hundredstepGoBox.setAlignment(Pos.BOTTOM_RIGHT);
			hundredstepGoBox.getChildren().add(hundredstepGo);
			grid.add(hundredstepGoBox, 4, 8);
			hundredstepGo.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Integer numSteps = (Integer) numStepsField.getValue();
					for (int i = 0; i < 100; i++) {
						Critter.worldTimeStep();
					}
					Critter.displayWorld();
				}
			});
			Button thousandstepGo = new Button("Take 1000 steps");
			HBox thousandstepGoBox = new HBox(10);
			thousandstepGoBox.setAlignment(Pos.BOTTOM_RIGHT);
			thousandstepGoBox.getChildren().add(thousandstepGo);
			grid.add(thousandstepGoBox, 5, 8);
			thousandstepGo.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					for (int i = 0; i < 1000; i++) {
						Critter.worldTimeStep();
					}
					Critter.displayWorld();
				}
			});

			// --------------------------------------------------------
			// Seed setting block
			Label seedLabel = new Label("Set seed:");
			grid.add(seedLabel, 0, 11);
			TextField seedField = new TextField();
			grid.add(seedField, 1, 11);
			Button seedButton = new Button("Set");
			HBox seedButtonBox = new HBox(10);
			seedButtonBox.setAlignment(Pos.BOTTOM_RIGHT);
			seedButtonBox.getChildren().add(seedButton);
			grid.add(seedButtonBox, 1, 12);
			final Text setSeedMsg = new Text();
			// setSeedMsg.setTextAlignment(TextAlignment.RIGHT);
			grid.add(setSeedMsg, 1, 13);
			seedButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					try {
						Critter.setSeed(Long.parseLong(seedField.getText()));
						setSeedMsg.setFill(Color.ROYALBLUE);
						setSeedMsg.setText(String.format("%s set as seed.", seedField.getText()));
					} catch (NumberFormatException e) {
						setSeedMsg.setFill(Color.FIREBRICK);
						setSeedMsg.setText(String.format("%s is not a valid seed value!", seedField.getText()));
					}
				}
			});
			// ----------------------------------------------------------
			

			Label animationLabel = new Label("Animation speed:");
			grid.add(animationLabel, 0, 9);
			Slider animationSlider = new Slider(0, 100, 50);
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
			animateButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					try {
						runAnimation = true;
						addBtn.setDisable(true);
						statsBtn.setDisable(true);
						stepGo.setDisable(true);
						onestepGo.setDisable(true);
						hundredstepGo.setDisable(true);
						thousandstepGo.setDisable(true);
						seedButton.setDisable(true);
						animationSlider.setDisable(true);
						stopButton.setDisable(false);
						aniThread = new Thread(new Animate((animationSlider.getValue())));
						aniThread.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			stopButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					try {
						runAnimation = false;
						addBtn.setDisable(false);
						statsBtn.setDisable(false);
						stepGo.setDisable(false);
						onestepGo.setDisable(false);
						hundredstepGo.setDisable(false);
						thousandstepGo.setDisable(false);
						seedButton.setDisable(false);
						animationSlider.setDisable(false);
						stopButton.setDisable(true);
						aniThread.interrupt();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

			 Stage stage2 = new Stage(); 
			 stage2.setResizable(false);
			 Group dispRoot = new Group();
			 final Canvas canvas = new Canvas(600,600); 
			 GraphicsContext gc = canvas.getGraphicsContext2D();
			 //gc.setFill(Color.RED); 
			 //gc.fillRect(0, 0, 600, 600);
			 dispRoot.getChildren().add(canvas); 
			 stage2.setScene(new Scene(dispRoot,600,600,Color.MINTCREAM));
			 stage2.setTitle("Critter World Display");
			 stage2.show();
			
			// grid.setGridLinesVisible(true);
			Scene scene = new Scene(grid, 1000, 600);
			primaryStage.setScene(scene);
			primaryStage.show();

			Button quitButton = new Button("Quit the simulation!");
			HBox quitButtonBox = new HBox(10);
			quitButtonBox.setAlignment(Pos.BOTTOM_RIGHT);
			quitButtonBox.getChildren().add(quitButton);
			grid.add(quitButtonBox, 1, 14);
			quitButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.exit(0);
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	protected void draw(GraphicsContext g){
		
	}
}
