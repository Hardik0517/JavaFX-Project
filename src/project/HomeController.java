/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author hardik
 */
public class HomeController implements Initializable {

    @FXML
    private Label label;
    private String us;
    @FXML
    private Label l1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            us=Project.getUser();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        l1.setText("Welcome "+us);
    }    

    @FXML
    private void handleButtonActionLogOut(ActionEvent event) throws IOException {
        Project.setRoot("FXMLDocument");
    }

    @FXML
    private void handleButtonActionFlight(ActionEvent event) throws IOException {
        Project.setRoot("Flight");
    }

    @FXML
    private void handleButtonActionBooking(ActionEvent event) throws IOException {
        Project.setRoot("ViewBooking");
    }

    @FXML
    private void handleButtonActionModify(ActionEvent event) throws IOException {
        Project.setRoot("Update");
    }
    
    @FXML
    private void handleButtonActionHome(ActionEvent event) throws IOException {
        Project.setRoot("Home");
    }
    
}
