/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.time.LocalDate;

/**
 *
 * @author hardik
 */
public class FlightModel {

    
    private String fid;
    private String Airline;
    private String Source;
    private String Destination;
    private String Duration;
    private String Price;
    private String Tdate;
    private String Depart;
    private String Arrival;
    
    
    public FlightModel(String fid,String airline,String source, String Destination,String duration ,String price,String Tdate,String Depart,String Arrival){
        this.fid=fid;
        this.Airline=airline;
        this.Source=source;
        this.Destination=Destination;
        this.Duration=duration;
        this.Price=price;   
        this.Tdate=Tdate;
        this.Depart=Depart;
        this.Arrival=Arrival;
    }

    public String getFid() {        return fid;    }
    public String getAirline() {        return Airline;    }
    public String getSource() {        return Source;    }
    public String getDestination() {        return Destination;    }
    public String getDuration() {        return Duration;    }
    public String getPrice() {        return Price;   }
    public String getTdate() {        return Tdate;    }
    public String getDepart() {        return Depart;    }
    public String getArrival() {        return Arrival;    }


}
