/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.*;
/**
 * FXML Controller class
 *
 * @author hardik
 */
public class SignUpController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField user;
    @FXML
    private TextField pwd;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private Label label1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonActionSignUp(ActionEvent event) {
       if(user.getText().equals("") || pwd.getText().equals("") || email.getText().equals("") || name.getText().equals("")){
           label1.setText("All fields are to be filled");
       }
       else if(email.getText().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")==false || pwd.getText().equals("\"^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$\"")==false ){
           label1.setText("Invalid Email ");
       }
       else {
           String a=(name.getText());
           String b=(user.getText());
           String c=(email.getText());
           String d=(pwd.getText());
 
           
           try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dreamtravel", "root", "");
            Statement s = con.createStatement();
            PreparedStatement statement = con.prepareStatement("select * from login where username='"+b+"'; ");
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                label1.setText("Username already exists");
            }
            else{
                String s1 = "insert into login(name,username,email,password) values ('" + a + "','" + b + "','" + c + "','" + d + "');";
            label1.setText("Sucessfully Added");
            s.executeUpdate(s1);
                
            }
            

        } catch (Exception e) {
            System.out.println(e);
        }
           
       }
    }

    @FXML
    private void handleButtonActionBack(ActionEvent event) throws IOException {
         Project.setRoot("FXMLDocument");
    }

    @FXML
    private void handleButtonActionClear(ActionEvent event) {
        user.clear();
        email.clear();
        pwd.clear();
        name.clear();
        label1.setText("");
    }
    
}
