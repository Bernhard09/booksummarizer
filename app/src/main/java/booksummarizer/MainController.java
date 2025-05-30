package booksummarizer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainController {
    @FXML
    private Label welcomeLabel;

    @FXML
    private Button loadBookButton;

    @FXML
    private Label fileNameLabel;

    @FXML
    private TextArea originalContentTextArea;

    // This method is automatically called after the FXML file has been loaded
    @FXML
    public void initialize() {
        welcomeLabel.setText("Book Summarizer V1"); // You can change the welcome text
        System.out.println("MainController initialized and ready.");
    }

    @FXML
    private void handleLoadBookAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Text File");
        
        // Set extension filter for .txt files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        Stage stage = (Stage) loadBookButton.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            fileNameLabel.setText("Selected file: " + selectedFile.getName());
            try {
                // Read content from the selected file 
                String content = readTextContent(selectedFile);
                originalContentTextArea.setText(content);
            } catch (IOException e) {
                e.printStackTrace(); // Basic error handling
                originalContentTextArea.setText("Error: Could not read file.\n" + e.getMessage());
                fileNameLabel.setText("Error loading file.");
            }
        } else {
            fileNameLabel.setText("File selection cancelled.");
            originalContentTextArea.clear();
        }
    }

    // Retrieve content from .txt file
    private String readTextContent(File file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file.toURI())), StandardCharsets.UTF_8);
    }

    // Retrieve content from .pdf file
    // private String readPdfContent(File file) throws IOException {
        
    // }

    // Retrieve content from .epub file
    // private String readEpubContent(File file) throws IOException {

    // }
}
