/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hardik
 */
public class FlightController implements Initializable {
    
    
    @FXML
    private Label l2;
    String us;
    String src;
    String dstn;
    LocalDate dt;
    @FXML
    private DatePicker date;
    @FXML
    private TextField From;
    @FXML
    private TextField To;
    @FXML
    private Label label4;
    @FXML
    private Label l4;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            us=Project.getUser();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FlightController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        l2.setText("Welcome "+us);
        
    }    

    @FXML
    private void handleButtonActionHome(ActionEvent event) throws IOException {
        Project.setRoot("Home");
    }

    @FXML
    private void handleButtonActionSearch(ActionEvent event) throws IOException {
        if(date.getValue()==null || From.getText().matches("")||To.getText().matches("")){
            label4.setText("All fields are to be filled");
        }
        else{
            src=From.getText();
        dstn=To.getText();
        dt=date.getValue();
        if(src.matches(dstn)){
            label4.setText("Same source and destination!");
        }
        else{
            //System.out.print(dt);
        Project.setSource(src);
        Project.setDest(dstn);
        Project.setDate(dt);
       
        Project.setRoot("Search");
        }
        
        }
        
    }
    
    
}
