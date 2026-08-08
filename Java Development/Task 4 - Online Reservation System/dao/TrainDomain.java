
package za.ac.cput.onlinereservationsystem.domain;

/**
 *
 * @author PC
 */
public class TrainDomain {
    private String trainNumber;
    private String trainName;
    
    public TrainDomain(){
        
    }

    public TrainDomain(String trainNumber, String trainName) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    @Override
    public String toString() {
        return "TrainDomain{" + "trainNumber=" + trainNumber + ", trainName=" + trainName + '}';
    }
    
}
