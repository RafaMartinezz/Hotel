/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * Controller for the main form (FormularioPrincipal) in a hotel reservation
 * system.
 * Provides methods to handle button and menu item actions for room and hall
 * reservations,
 * as well as an option to exit the application.
 * 
 * @version 1.0
 */
public class FormularioPrincipalController implements Initializable {

    @FXML
    private Button btnReservasHabitacion; // Button to navigate to room reservation

    @FXML
    private MenuItem mniReservasHabitacion; // Menu item to navigate to room reservation

    @FXML
    private Button btnReservasSalon; // Button to navigate to hall reservation

    @FXML
    private MenuItem mniReservasSalon; // Menu item to navigate to hall reservation

    @FXML
    private Button btnSalir; // Button to exit the application

    /**
     * Initializes the controller class. Sets up any necessary configurations.
     * 
     * @param url URL for the FXML file location
     * @param rb  ResourceBundle for localization, if any
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Any necessary initialization can be added here
    }

    /**
     * Handles the event triggered by clicking the "Room Reservations" button.
     * Navigates to the "Room Reservation" form (ReservaHabitacion.fxml).
     *
     * @param event The action event triggered by clicking the button
     * @throws IOException if the FXML file cannot be loaded
     */
    public void handlebtnReservasHabitacion(ActionEvent event) throws IOException {
        // Retrieve the current stage and load the Room Reservation form
        Stage stage = (Stage) btnReservasHabitacion.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/hotel/vista/ReservaHabitacion.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handles the event triggered by clicking the "Room Reservations" menu item.
     * Opens the "Room Reservation" form in the same window.
     *
     * @param event The action event triggered by selecting the menu item
     * @throws IOException if the FXML file cannot be loaded
     */
    public void handlemniReservasHabitacion(ActionEvent event) throws IOException {
        // Retrieve the current stage and load the Room Reservation form
        MenuItem menuItem = (MenuItem) event.getSource();
        Stage stage = (Stage) mniReservasSalon.getParentPopup().getOwnerWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/hotel/vista/ReservaHabitacion.fxml"));

        // Set the scene to the Room Reservation form if the correct menu item is
        // clicked
        if ("mniReservasHabitacion".equals(menuItem.getId())) {
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    /**
     * Handles the event triggered by clicking the "Hall Reservations" button.
     * Navigates to the "Hall Reservation" form (ReservaSalon.fxml).
     *
     * @param event The action event triggered by clicking the button
     * @throws IOException if the FXML file cannot be loaded
     */
    public void handlebtnReservasSalon(ActionEvent event) throws IOException {
        // Retrieve the current stage and load the Hall Reservation form
        Stage stage = (Stage) btnReservasSalon.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/hotel/vista/ReservaSalon.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handles the event triggered by clicking the "Hall Reservations" menu item.
     * Opens the "Hall Reservation" form in the same window.
     *
     * @param event The action event triggered by selecting the menu item
     * @throws IOException if the FXML file cannot be loaded
     */
    public void handlemniReservasSalon(ActionEvent event) throws IOException {
        // Retrieve the current stage and load the Hall Reservation form
        MenuItem menuItem = (MenuItem) event.getSource();
        Stage stage = (Stage) btnReservasSalon.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/hotel/vista/ReservaSalon.fxml"));

        // Set the scene to the Hall Reservation form if the correct menu item is
        // clicked
        if ("mniReservasSalon".equals(menuItem.getId())) {
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    /**
     * Handles the event triggered by clicking the "Exit" button.
     * Closes the application.
     *
     * @param event The action event triggered by clicking the button
     * @throws IOException if an input/output exception occurs
     */
    public void handlebtnSalir(ActionEvent event) throws IOException {
        // Exit the application
        Platform.exit();
        System.exit(0);
    }

}
