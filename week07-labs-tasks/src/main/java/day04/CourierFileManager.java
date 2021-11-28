package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CourierFileManager {
    public static void main(String[] args) {
        CourierFileManager courierFileManager=new CourierFileManager();
        Courier courier=courierFileManager.createCourierByFile(Paths.get("src/main/resources/futar.txt"));
        System.out.println(courier);
        Courier courierNOK=courierFileManager.createCourierByFile(Paths.get("src/main/resources/futarNOK.txt"));
        System.out.println(courierNOK);
    }
    public Courier createCourierByFile(Path path){
        List<String> all = readFile(path);
        Courier courier=new Courier();
        int day;
        int noOfRide;
        int distance;
        Ride ride;
        int actualDay=0;
        String[] record;
        for (int i=0; i<all.size();i++){
            record=all.get(i).split(" ");
            day=Integer.parseInt(record[0]);
            distance=Integer.parseInt(record[2]);
            actualDay=checkDay(day,actualDay);
            noOfRide=courier.numberOfRidesOnDay(day)+1;
            ride=new Ride(day,noOfRide,distance);
            courier.addRide(ride);
        }
        return courier;
    }
    private int checkDay(int day, int actualDay){
        if(day>actualDay){
            actualDay=day;
        }
        if(day<actualDay){
            throw new IllegalArgumentException("Problem with the record order!");
        }
        return actualDay;
    }
    public List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file: "+path, ioe);
        }
    }
}
