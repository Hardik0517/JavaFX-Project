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
public class SuccessfullyBookedController implements Initializable {

    @FXML
    private Label l2;
    String us;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            us=Project.getUser();
        } catch (IOException ex) {
            Logger.getLogger(SuccessfullyBookedController.class.getName()).log(Level.SEVERE, null, ex);
        }
        l2.setText("Welcome "+us);
    }    

    @FXML
    private void handleButtonActionHome(ActionEvent event) throws IOException {
        Project.setRoot("Home");
    }

    
}
