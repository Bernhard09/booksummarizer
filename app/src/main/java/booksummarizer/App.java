package booksummarizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class App extends Application{
    // public String getGreeting() {
    //     return "Hello World!";
    // }

    // @Override
    // public void start(Stage primaryStage) {
    //     Label label = new Label("Hello World!");
    //     StackPane root = new StackPane();
    //     root.getChildren().add(label);  
    //     Scene scene = new Scene(root, 300, 200);
        
    //     primaryStage.setTitle("JavaFX App");
    //     primaryStage.setScene(scene);
    //     primaryStage.show();
    // }

    @Override
    public void start(Stage primaryStage) {
        try {
            URL fxmlUrl = getClass().getResource("MainView.fxml"); 
            
            if (fxmlUrl == null) {
                System.err.println("ERROR: Cannot find FXML file 'MainView.fxml'.");

                return; 
            }

            Parent root = FXMLLoader.load(fxmlUrl);
            
            // The scene dimensions (800, 700)
            Scene scene = new Scene(root); 

            primaryStage.setTitle("Book Summarizer");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            // This catch block will handle errors if FXMLLoader.load() fails,
            System.err.println("Failed to load FXML or initialize the scene:");
            e.printStackTrace(); 
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
