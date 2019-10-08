package javaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxTuts extends Application {
	public JavaFxTuts() {
		// Optional constructor
	}

	@Override
	public void init() {
		// By default this does nothing, but it
		// can carry out code to set up your app.
		// It runs once before the start method,
		// and after the constructor.
	}

	@Override
	public void start(Stage primaryStage) {
		// Creating the Java button
		final Button button = new Button();
		// Setting text to button
		button.setText("Hello World");
		// Registering a handler for button
		button.setOnAction((ActionEvent event) -> {
			// Printing Hello World! to the console
			System.out.println("Hello World!");
		});
		// Initializing the StackPane class
		final StackPane root = new StackPane();
		// Adding all the nodes to the FlowPane
		root.getChildren().add(button);
		// Creating a scene object
		final Scene scene = new Scene(root, 300, 250);
		// Adding the title to the window (primaryStage)
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		// Show the window(primaryStage)
		primaryStage.show();
	}

	@Override
	public void stop() {
		// By default this does nothing
		// It runs if the user clicks the go-away button
		// closing the window or if Platorm.exit() is called.
		// Use Platorm.exit() instead of System.exit(0).
		// is called. This is where you should offer to
		// save unsaved stuff the user has generated.
	}

	/**
	 * Main function that opens the "Hello World!" window
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(final String[] arguments) {
		launch(arguments);
	}
}