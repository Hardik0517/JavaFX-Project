/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author hardik
 */
public class ViewModel {
    private String fid;
    private String Airline;
    private String Source;
    private String Destination;
    private String Tdate;
    private String Price;
    private String Payment;
    private String Depart;
    private String Arrival;
    public ViewModel(String fid,String Airline,String Source, String Destination,String Tdate ,String Price,String Payment,String Depart,String Arrival){
        this.fid=fid;
        this.Airline=Airline;
        this.Source=Source;
        this.Destination=Destination;
        this.Price=Price;   
        this.Tdate=Tdate;
        this.Payment=Payment;
        this.Depart=Depart;
        this.Arrival=Arrival;
    }

    public String getFid() {        return fid;    }

    public String getAirline() {        return Airline;    }

    
    public String getSource() {        return Source;    }

    public String getDestination() {        return Destination;    }

    public String getTdate() {        return Tdate;    }

    public String getPrice() {        return Price;    }

    public String getPayment() {        return Payment;    }

    public String getDepart() {        return Depart;    }

    public String getArrival() {        return Arrival;    }
}

