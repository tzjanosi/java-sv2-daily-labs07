package day04;

import java.util.ArrayList;
import java.util.List;

public class Courier {
    private List<Ride> rides=new ArrayList<>();

    public void addRide(Ride ride){
        rides.add(ride);
    }
    public int numberOfRidesOnDay(int day){
        int numberOfRides=0;
        for(Ride ride:rides) {
            if(ride.getDay()==day){
                if(ride.getNoOfRide()>numberOfRides){
                    numberOfRides=ride.getNoOfRide();
                }
            }
        }
        return numberOfRides;
    }

    public List<Ride> getRides() {
        return rides;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "rides=" + rides +
                '}';
    }
}
