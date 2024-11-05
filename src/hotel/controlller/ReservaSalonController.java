/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

/**
 * Controller class for handling events and data input in the ReservaSalon view.
 * This controller manages UI components such as ComboBoxes, Spinners, and
 * DatePickers
 * for salon reservation configurations.
 * 
 * @version 1.0
 */
public class ReservaSalonController implements Initializable {

    // UI components from the FXML file
    @FXML
    private ComboBox<String> comboBoxSalones; // Dropdown to select a salon type

    @FXML
    private ComboBox<String> comboBoxCocina; // Dropdown to select a catering option

    @FXML
    private Button btnAtras; // Button to go back to the main form

    @FXML
    private Spinner<Integer> spAsistentes; // Spinner for selecting number of attendees
    final int initialValue = 1; // Initial value for Spinners
    SpinnerValueFactory<Integer> svfAsistentes = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100,
            initialValue);

    @FXML
    private Spinner<Integer> spDias; // Spinner for selecting number of reservation days
    SpinnerValueFactory<Integer> svfDias = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 7, initialValue);

    @FXML
    private DatePicker dpFecha; // DatePicker for selecting the reservation date

    @FXML
    private Label lbDias; // Label for displaying "Days" option for Empresa events

    @FXML
    private Label lbHabitaciones; // Label for displaying "Rooms" option for Boda events

    @FXML
    private CheckBox cbHabitaciones; // Checkbox for selecting room availability for Boda events

    @FXML
    private RadioButton rbBoda; // RadioButton to select "Wedding" event type

    @FXML
    private RadioButton rbEmpresa; // RadioButton to select "Corporate" event type

    /**
     * Initializes the controller class by setting up initial states for ComboBoxes,
     * Spinners, DatePickers, and other UI elements.
     * 
     * @param url URL for the FXML file location.
     * @param rb  ResourceBundle for localization (not used here).
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Populate ComboBox for salon types with an initial selection option
        comboBoxSalones.getItems().addAll("Salón principal");

        // Populate ComboBox for catering options
        comboBoxCocina.getItems().addAll("Menú cerrado", "A la carta", "Lo ponen los clientes", "Por concretar");

        // Configure Spinners for attendees and days with initial values
        spAsistentes.setValueFactory(svfAsistentes);
        spDias.setValueFactory(svfDias);

        // Configure DatePicker to start with the current date and disable past dates
        LocalDate today = LocalDate.now();
        dpFecha.setValue(today);
        dpFecha.setDayCellFactory((final DatePicker param) -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                // Disable past dates and apply a custom style
                if (item.isBefore(today)) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;");
                }
            }
        });

        // Initially disable labels and components related to Days and Rooms options
        lbDias.setDisable(true);
        spDias.setDisable(true);
        lbHabitaciones.setDisable(true);
        cbHabitaciones.setDisable(true);
    }

    /**
     * Handles the action triggered by clicking the "Back" button.
     * Returns the user to the main form view.
     * 
     * @param event ActionEvent triggered by clicking the "Back" button.
     * @throws IOException if the FXML file for the main form cannot be loaded.
     */
    public void handleBtnAtras(ActionEvent event) throws IOException {
        // Get the current stage (window) and load the main form view
        Stage stage = (Stage) btnAtras.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/hotel/vista/ReservaSalon.fxml"));
        if (event.getSource() == btnAtras) {
            // Ensure the event source is the "Back" button
            stage = (Stage) btnAtras.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/hotel/vista/FormularioPrincipal.fxml"));
        }

        // Update the scene with the main form view
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handles the event triggered by selecting a RadioButton (either "Wedding" or
     * "Corporate" event type).
     * Enables or disables certain UI components based on the selected event type.
     * 
     * @param event ActionEvent triggered by selecting a RadioButton.
     * @throws IOException Not thrown in this implementation, but included for
     *                     completeness.
     */
    public void handleRb(ActionEvent event) throws IOException {
        if (event.getSource() == rbBoda) {
            // Show "Rooms" options for wedding events
            lbHabitaciones.setDisable(false);
            cbHabitaciones.setDisable(false);
            lbDias.setDisable(true);
            spDias.setDisable(true);
        } else if (event.getSource() == rbEmpresa) {
            // Show "Days" options for corporate events
            lbHabitaciones.setDisable(true);
            cbHabitaciones.setDisable(true);
            lbDias.setDisable(false);
            spDias.setDisable(false);
        } else {
            // Default case to disable both options
            lbDias.setDisable(true);
            spDias.setDisable(true);
            lbHabitaciones.setDisable(true);
            cbHabitaciones.setDisable(true);
        }
    }
}
