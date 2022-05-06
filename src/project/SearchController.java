/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project;

import java.sql.*;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static project.Project.date;
/**
 * FXML Controller class
 *
 * @author hardik
 */
public class SearchController implements Initializable {
    String us,sc,dtn;
    LocalDate date_of_t;
    @FXML
    private Label l2;
    @FXML
    private TableColumn<FlightModel,String> flightid;
    @FXML
    private TableColumn<FlightModel,String>  arline;
    @FXML
    private TableColumn<FlightModel,String>  source;
    @FXML
    private TableView<FlightModel> ftable;
    @FXML
    private TableColumn<FlightModel,String>  destination;
    @FXML
    private TableColumn<FlightModel,String>  duration;
    @FXML
    private TableColumn<FlightModel,String> price;
    @FXML
    private Label l3;
    @FXML
    private TableColumn<FlightModel, String> tdate;
    @FXML
    private TextField finalid;
    String strDate,cb;
    @FXML
    private ChoiceBox<String> choicebox;
    private String pay[]={"UPI","NetBanking","Credi Card"};
    @FXML
    private TableColumn<FlightModel, String> depart;
    @FXML
    private TableColumn<FlightModel, String> arrival;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choicebox.getItems().addAll(pay);
        try {
            us=Project.getUser();
            sc=Project.getSource();
            dtn=Project.getDest();
            date_of_t=Project.getDate();
            
            
        } catch (IOException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        l2.setText("Welcome "+us);
        flightid.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("fid"));
        arline.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("Airline"));
        source.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("Source"));
        destination.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("Destination"));
        duration.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("Duration"));
        price.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("Price"));
        tdate.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("Tdate"));
        depart.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("Depart"));
        arrival.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("Arrival"));
        ObservableList<FlightModel> items = FXCollections.observableArrayList();

        try {
             Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dreamtravel", "root", "");
            Statement s = con.createStatement();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            Date date_of_t1 = Date.valueOf(date_of_t);
            strDate = dateFormat.format(date_of_t1);  
            PreparedStatement statement = con.prepareStatement("select * from flight where Source='"+sc+"' and Destination='"+dtn+"' and TravelDate='"+strDate+"'");
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                String s0 = rs.getString(1);
                String s1 = rs.getString(2);
                String s2 = rs.getString(3);
                String s3 = rs.getString(4);
                String s4 = rs.getString(5);
                String s5 = rs.getString(6);
               String s6=rs.getString(8);
               String s7=rs.getString(9);
               items.add(new FlightModel(s0, s1, s2, s3, s4, s5,strDate,s6,s7));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        ftable.setItems(items);

    
    }    

    @FXML
    private void handleButtonActionHome(ActionEvent event) throws IOException {
        Project.setRoot("Home");
    }

    @FXML
    private void handleButtonActionBack(ActionEvent event) throws IOException {
        Project.setRoot("Flight");
    }

    String s1,s2,s3,s4,s5,s6,s7;
    @FXML
    private void handleButtonActioncnfrm(ActionEvent event) throws IOException {
        String fbookid=finalid.getText();
        String usbook=Project.getUser();
        cb=choicebox.getValue();
        if(cb==null|fbookid.matches("")){
            l3.setText("Enter Valid Details");
        }
        else{
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dreamtravel", "root", "");
            Statement s = con.createStatement(); 
            PreparedStatement statement = con.prepareStatement("select * from flight where fid='"+fbookid+"' and Source='"+sc+"' and Destination='"+dtn+"' and TravelDate='"+strDate+"'");
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                s1 = rs.getString(2);
                s2 = rs.getString(3);
                s3 = rs.getString(4);
                s5 = rs.getString(6);
                s6=rs.getString(8);
                s7=rs.getString(9);
                String st1 = "insert into booked(username,fid,airline,source,destination ,TravelDate,Price,payment,departure,arrival) values ('" + usbook+ "','" +fbookid + "','" + s1 + "','" + s2 + "','" + s3+ "','" +strDate + "','" + s5 + "','" + cb + "','" + s6 + "','" + s7 + "');";
                s.executeUpdate(st1);
                Project.setRoot("SuccessfullyBooked");
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        }
        
        
    }
    
}
