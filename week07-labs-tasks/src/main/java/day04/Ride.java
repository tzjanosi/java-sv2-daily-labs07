package day04;

public class Ride {
    private int day;
    private int noOfRide;
    private int distance;

    public Ride(int day, int noOfRide, int distance) {
        this.day = day;
        this.noOfRide = noOfRide;
        this.distance = distance;
    }

    public int getDay() {
        return day;
    }

    public int getNoOfRide() {
        return noOfRide;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "day=" + day +
                ", noOfRide=" + noOfRide +
                ", distance=" + distance +
                '}';
    }
}
