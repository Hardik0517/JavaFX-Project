package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hardik
 */
public class UpdateController implements Initializable {
    String userna,s0,s4;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private TableView<ViewModel> vtable;
    @FXML
    private TableColumn<ViewModel, String> flid;
    @FXML
    private TableColumn<ViewModel, String>airline;
    @FXML
    private TableColumn<ViewModel, String> source;
    @FXML
    private TableColumn<ViewModel, String> destination;
    @FXML
    private TableColumn<ViewModel, String>tdate;
    @FXML
    private TableColumn<ViewModel, String> price;
    @FXML
    private TableColumn<ViewModel, String>payment;
    @FXML
    private TableColumn<ViewModel, String> depart;
    @FXML
    private TableColumn<ViewModel, String> arrival;
    @FXML
    private TextField rfid;
    @FXML
    private DatePicker rdate;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            userna=Project.getUser();
        } catch (IOException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        l2.setText("Welcome "+userna);
        flid.setCellValueFactory(new PropertyValueFactory<ViewModel, String>("fid"));
        airline.setCellValueFactory(new PropertyValueFactory<ViewModel, String>("Airline"));
        source.setCellValueFactory(new PropertyValueFactory<ViewModel, String>("Source"));
        destination.setCellValueFactory(new PropertyValueFactory<ViewModel, String>("Destination"));
        price.setCellValueFactory(new PropertyValueFactory<ViewModel, String>("Price"));
        tdate.setCellValueFactory(new PropertyValueFactory<ViewModel, String>("Tdate"));
        payment.setCellValueFactory(new PropertyValueFactory<ViewModel, String>("Payment"));
        depart.setCellValueFactory(new PropertyValueFactory<ViewModel, String>("Depart"));
        arrival.setCellValueFactory(new PropertyValueFactory<ViewModel, String>("Arrival"));
        ObservableList<ViewModel> items = FXCollections.observableArrayList();
        try {
             Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dreamtravel", "root", "");
            Statement s = con.createStatement();
            PreparedStatement statement = con.prepareStatement("select * from booked where username='"+userna+"'");
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                s0 = rs.getString(2);
                String s1 = rs.getString(3);
                String s2 = rs.getString(4);
                String s3 = rs.getString(5);
                 s4 = rs.getString(6);
                String s5 = rs.getString(7);
               String s6=rs.getString(8);
               String s7=rs.getString(9);
               String s8=rs.getString(10);
               items.add(new ViewModel(s0, s1, s2, s3, s4, s5,s6,s7,s8));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        vtable.setItems(items);
    }    

    @FXML
    private void handleButtonActionHome(ActionEvent event) throws IOException {
        Project.setRoot("Home");
    }

    @FXML
    private void handleButtonActionBack(ActionEvent event) throws IOException {
        Project.setRoot("Home");
    }

    @FXML
    private void handleButtonActionUpdate(ActionEvent event) throws IOException {
        if(rdate.getValue()==null){
            l3.setText("Enter Date to Reschedule");
        }
        else{
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dreamtravel", "root", "");
            Statement s = con.createStatement();
            
            PreparedStatement statement = con.prepareStatement("select * from booked where username='"+userna+"' and fid='"+rfid.getText()+"'");
            ResultSet rs = statement.executeQuery();
            if(rs.next()==false){
                l3.setText("Enter Valid FlightId");
            }
            else{
                String sq = "update booked set TravelDate='"+rdate.getValue()+"' where fid='"+rfid.getText()+"' and username='"+userna+"'";
            s.executeUpdate(sq);
            con.close();
            Project.setRoot("MsgUpdate");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        }
    }
    
}