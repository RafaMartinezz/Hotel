/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package hotel.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for the hotel management application using JavaFX.
 * This class serves as the entry point of the application, loading the main
 * form (FormularioPrincipal.fxml)
 * and displaying it on the primary stage.
 * 
 * @version 1.0
 */
public class HotelApp extends Application {

    /**
     * The start method is called after the JavaFX application toolkit is
     * initialized.
     * This method loads the main form FXML, sets up the primary stage, and shows
     * it.
     *
     * @param stage The primary stage for this application.
     * @throws Exception if the FXML file cannot be loaded or if there's an issue
     *                   with rendering.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file for the main form and create the scene graph.
        Parent root = FXMLLoader.load(getClass().getResource("/hotel/vista/FormularioPrincipal.fxml"));

        // Set the title of the application window.
        stage.setTitle("Xestión Hoteleira BK");

        // Create a new scene with the loaded root element and set it on the stage.
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Show the stage with the main form loaded.
        stage.show();
    }

    /**
     * Main method, entry point for the application.
     * Calls the JavaFX launch method to start the application lifecycle.
     * 
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        launch(args);
    }
}
