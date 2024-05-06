package cleaning.menu;
import cleaning.service.CleaningService;

import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;


// Create a class called CleaningCompanyUI that extends the Application class
public class CleaningCompanyUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // Override the start method
    @Override
    public void start(Stage primaryStage) {
        CleaningService cleaningService = new CleaningService();
        primaryStage.setTitle("UiFLY Cleaning Company");
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(400);

        // Create a label for the welcome message
        // With Font size is set to 20 and the font is set to Noto Sans JP
        Label label = new Label("Welcome to UiFLY Cleaning Company!");
        label.setFont(new Font("Noto Sans JP", 20));
        label.setTextFill(Color.WHITE);

        // Create buttons for the menu options

        Button addCleanerButton = new Button("Add new cleaner");
        addCleanerButton.setOnAction(e -> addCleaner(cleaningService));

        Button assignJobButton = new Button("Assign job to cleaner");
        assignJobButton.setOnAction(e -> assignJob(cleaningService));

        Button viewJobsButton = new Button("View assigned jobs");
        viewJobsButton.setOnAction(e -> viewJobs(cleaningService));

        Button viewCleanersButton = new Button("View available cleaners");
        viewCleanersButton.setOnAction(e -> viewCleaners(cleaningService));

        Button removeCleanerButton = new Button("Remove cleaner");
        removeCleanerButton.setOnAction(e -> removeCleaner(cleaningService));

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> Platform.exit());

        // Create an HBox to hold the buttons with a spacing of 10 and centered alignment
        // Add the buttons to the HBox and set the style for the buttons
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(addCleanerButton, assignJobButton, viewJobsButton, viewCleanersButton, removeCleanerButton, exitButton);
        addCleanerButton.setStyle("-fx-background-color: #ff6347; -fx-text-fill: white; -fx-font-size: 14px;");
        assignJobButton.setStyle("-fx-background-color: #ff6347; -fx-text-fill: white; -fx-font-size: 14px;");
        viewJobsButton.setStyle("-fx-background-color: #ff6347; -fx-text-fill: white; -fx-font-size: 14px;");
        viewCleanersButton.setStyle("-fx-background-color: #ff6347; -fx-text-fill: white; -fx-font-size: 14px;");
        removeCleanerButton.setStyle("-fx-background-color: #ff6347; -fx-text-fill: white; -fx-font-size: 14px;");
        exitButton.setStyle("-fx-background-color: #ff6347; -fx-text-fill: white; -fx-font-size: 14px;");

        // Create a VBox to hold the label and HBox
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label, hBox);
        vBox.setStyle("-fx-background-image: url('/dst.jpeg') ; -fx-background-size: cover; -fx-background-position: center; -fx-background-repeat: no-repeat;");
        vBox.setMinSize(400, 400);

        // Set the scene
        Scene scene = new Scene(vBox, 400, 400);
        scene.setFill(Color.LIGHTGRAY);
        primaryStage.setScene(scene);
        primaryStage.show();


        // Set the event handlers for the buttons

        addCleanerButton.setOnAction(e -> {
            System.out.println("Add Cleaner Button was clicked");
            addCleaner(cleaningService);
        });

        assignJobButton.setOnAction(e -> {
            System.out.println("Assign Job Button was clicked");
            assignJob(cleaningService);
        });

        viewJobsButton.setOnAction(e -> {
            System.out.println("View Jobs Button was clicked");
            viewJobs(cleaningService);
        });

        viewCleanersButton.setOnAction(e -> {
            System.out.println("View Cleaners Button was clicked");
            viewCleaners(cleaningService);
        });

        removeCleanerButton.setOnAction(e -> {
            System.out.println("Remove Cleaner Button was clicked");
            removeCleaner(cleaningService);
        });

        exitButton.setOnAction(e -> {
            System.out.println("Exit Button was clicked");
            Platform.exit();
        });


    }


    // Create a method to add a cleaner
    // This method will display a dialog box to enter cleaner details
    private void addCleaner(CleaningService cleaningService) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add new cleaner");
        dialog.setHeaderText("Enter Cleaner Details");
        dialog.setContentText("Enter Cleaner Name, Address, Phone Number, ID: ");
        dialog.showAndWait().ifPresent(input -> {
            String[] details = input.split(",");
            String name = details[0];
            String address = details[1];
            String contactInfo = details[2];
            int ID = Integer.parseInt(details[3]);
            cleaningService.addNewCleaner(name, address, contactInfo, ID);


    });
    }

    // Create a method to assign a job to a cleaner
    // This method will display a dialog box to enter job details
    private void assignJob(CleaningService cleaningService) {
        // Check if there are available cleaners
        if (cleaningService.viewAvailableCleaners().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("No cleaners available");
            alert.setHeaderText("No cleaners available to assign job to");
            alert.showAndWait();
            return;


        }
        // Create a dialog box to enter job details
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Assign job to cleaner");
        dialog.setHeaderText("Enter job details to assign to cleaner");
        dialog.setContentText("Enter job ID, job description, cleaner ID: ");
        dialog.showAndWait().ifPresent(input -> {
            String[] details = input.split(",");
            int jobId = Integer.parseInt(details[0]);
            String jobDescription = details[1];
            int cleanerID = Integer.parseInt(details[2]);

            // Check if the cleaner exists

            if (cleaningService.viewAvailableCleaners().stream().noneMatch(cleaner -> cleaner.getID() == cleanerID)) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Cleaner not found");
                alert.setHeaderText("Cleaner with ID " + cleanerID + " not found");
                alert.showAndWait();
                return;
            }

            cleaningService.assignJobToCleaner(jobId, jobDescription, cleanerID);
        });

    }

    // Create a method to view assigned jobs
    // This method will display a dialog box with a list of assigned jobs
    private void viewJobs(CleaningService cleaningService) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Assigned jobs");
        alert.setHeaderText("List of assigned jobs");
        alert.setContentText(cleaningService.viewAssignedJobs().toString());
        alert.showAndWait();

    }

    // Create a method to view available cleaners
    // This method will display a dialog box with a list of available cleaners
    private void viewCleaners(CleaningService cleaningService) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Available cleaners");
        alert.setHeaderText("List of available cleaners");
        alert.setContentText(cleaningService.viewAvailableCleaners().toString());
        alert.showAndWait();

    }

    // Create a method to remove a cleaner
    // This method will display a dialog box to enter the cleaner ID to remove
    private void removeCleaner(CleaningService cleaningService) {
           TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Remove cleaner");
        dialog.setHeaderText("Enter cleaner ID to remove");
        dialog.setContentText("Enter cleaner ID: ");
        dialog.showAndWait().ifPresent(input -> {
            int cleanerIDToRemove = Integer.parseInt(input);
            // Check if the cleaner exists
            if (cleaningService.viewAvailableCleaners().stream().noneMatch(cleaner -> cleaner.getID() == cleanerIDToRemove)) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Cleaner not found");
                alert.setHeaderText("Cleaner with ID " + cleanerIDToRemove + " not found");
                alert.showAndWait();
                return;
            }
            cleaningService.removeCleaner(cleanerIDToRemove);

        });

    }
}
