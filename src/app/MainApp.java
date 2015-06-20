
package app;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Testing using JavaFX
 * @author morvanabonin
 */
public class MainApp extends Application {
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
	this.primaryStage = primaryStage;
	this.primaryStage.setTitle("Test JavaFX");
	this.primaryStage.show();
    }
    
    public void myApp(String[] args) {
	launch(args);
    }
}
