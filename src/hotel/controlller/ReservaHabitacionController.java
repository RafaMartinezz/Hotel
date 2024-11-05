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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Controller class for handling hotel room reservations in the
 * ReservaHabitacion view.
 * This controller manages UI components like ComboBox, CheckBox, DatePickers,
 * and handles events.
 * 
 * @version 1.0
 */
public class ReservaHabitacionController implements Initializable {

    // UI components from the FXML file
    @FXML
    private ComboBox<String> comboBox; // Dropdown for selecting room types
    @FXML
    private CheckBox checkBox; // Checkbox to display an additional warning or option
    @FXML
    private Text aviso; // Warning message, visibility controlled by checkbox
    @FXML
    private Button btnAtras; // Button to go back to the previous view
    @FXML
    private DatePicker dpLlegada; // DatePicker for selecting the arrival date
    @FXML
    private DatePicker dpSalida; // DatePicker for selecting the departure date

    /**
     * Configures the specified DatePicker to disable past dates and apply custom
     * styling.
     * 
     * @param dp The DatePicker to configure.
     */
    public void dpConf(DatePicker dp) {
        LocalDate today = LocalDate.now();

        // Set initial date to today
        dp.setValue(today);

        // Disable past dates and apply styles
        dp.setDayCellFactory(new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker param) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        // Disable cells for dates before today
                        if (item.isBefore(today)) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;"); // Apply a pink color to disabled dates
                        }
                    }
                };
            }
        });
    }

    /**
     * Initializes the controller class and sets up initial UI component states.
     * Loads items into the ComboBox, hides the warning Text, and configures
     * DatePickers.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Populate ComboBox with room type options
        comboBox.getItems().addAll("Doble de uso individual", "Doble", "Junior Suite", "Suite");

        // Initially hide the warning text
        aviso.setVisible(false);

        // Configure DatePickers for arrival and departure dates
        dpConf(dpLlegada);
        dpConf(dpSalida);
    }

    /**
     * Toggles the visibility of the warning Text based on the CheckBox selection
     * state.
     */
    public void handleCheckBox() {
        // Show warning message if CheckBox is selected, otherwise hide it
        aviso.setVisible(checkBox.isSelected());
    }

    /**
     * Handles the event triggered when the "Back" button is clicked.
     * Loads the main form view to return to the previous screen.
     * 
     * @param event The action event triggered by clicking the "Back" button.
     * @throws IOException if the FXML file cannot be loaded.
     */
    public void handleBtnAtras(ActionEvent event) throws IOException {
        // Retrieve the current stage from the button's scene
        Stage stage = (Stage) btnAtras.getScene().getWindow();

        // Load the previous form (FormularioPrincipal)
        Parent root = FXMLLoader.load(getClass().getResource("/hotel/vista/FormularioPrincipal.fxml"));

        // Check the source of the event to ensure it was triggered by btnAtras
        if (event.getSource() == btnAtras) {
            root = FXMLLoader.load(getClass().getResource("/hotel/vista/FormularioPrincipal.fxml"));
        }

        // Set the new scene and show it on the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
