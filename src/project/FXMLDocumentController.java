/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
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
 *
 * @author hardik
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    
    
    public static String usern;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonActionLogIn(ActionEvent event) throws IOException {
        if(username.getText().equals("") && password.getText().equals("")){
            label.setText("Enter Valid Details");
        }
        
       else {
           String a=(username.getText());
           String b=(password.getText());
           usern=a;
           Project.setUser(usern);
           try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dreamtravel", "root", "");
            Statement s = con.createStatement();
            PreparedStatement statement = con.prepareStatement("select * from login where username='"+a+"' and password='"+b+"';");
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                Project.setRoot("Home");
            }
            else{
            label.setText("Invalid Credentials");
                
            }
            con.close();
            

        } catch (Exception e) {
            System.out.println(e);
        }
        }
       
    }

    @FXML
    private void handleButtonActionSignIn(ActionEvent event) throws Exception {

        Project.setRoot("SignUp");
    }

    
}
