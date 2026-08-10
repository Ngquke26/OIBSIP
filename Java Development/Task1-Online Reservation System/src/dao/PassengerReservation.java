
package za.ac.cput.onlinereservationsystem.domain;

/**
 *
 * @author PC
 */
public class PassengerReservation {
   // private int pnr;
    private String passengerName;
    private String trainNumber;
    private String trainName;
    private String classType;
    private String journeyDate;
    private String source;
    private String destination;

    public PassengerReservation() {
    }

    public PassengerReservation( String passengerName, String trainNumber, String trainName, String classType, String journeyDate, String source, String destination) {
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.source = source;
        this.destination = destination;
    }
/*
    public int getPnr() {
        return pnr;
    }

    public void setPnr(int pnr) {
        this.pnr = pnr;
    }
    */
    public String getPassengerName() {
        return passengerName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getClassType() {
        return classType;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "PassengerReservation{" +  ", passengerName=" + passengerName + ", trainNumber=" + trainNumber + ", trainName=" + trainName + ", classType=" + classType + ", journeyDate=" + journeyDate + ", source=" + source + ", destination=" + destination + '}';
    }

   
    
    
    
    
}
