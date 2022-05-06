/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package project;

import java.io.IOException;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hardik
 */
public class Project extends Application {
    private static Scene scene;
    public static String usr;
    public static String source;
    public static String dest;
    public static LocalDate date;

    static String setUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        scene = new Scene(root);
        stage.setTitle("DreamTravels");
        stage.setScene(scene);
        stage.show();
    }
    
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    static void setUser(String str) throws IOException {
        usr=str;
    }
    
    static String getUser() throws IOException {
        return usr;
    }
    static void setSource(String str) throws IOException {
        source=str;
    }
    
    static String getSource() throws IOException {
        return source;
    }
    static void setDest(String str) throws IOException {
        dest=str;
    }
    
    static String getDest() throws IOException {
        return dest;
    }
    static void setDate(LocalDate str) throws IOException {
        date=str;
    }
    
    static LocalDate getDate() throws IOException {
        return date;
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Project.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
