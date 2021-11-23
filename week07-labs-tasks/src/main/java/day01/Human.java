package day01;
import java.time.LocalDate;

public class Human {
    private String name;
    private int yearOfBirth;

    public Human(String name, int yearOfBirth) {
        if(isYearOfBirthValid(yearOfBirth) && isNameValid(name)) {
            this.name = name;
            this.yearOfBirth = yearOfBirth;
        }
    }

    public boolean isYearOfBirthValid(int yearOfBirth){
        if(yearOfBirth<LocalDate.now().getYear()-120) {
            throw new IllegalArgumentException("The age should be below 120 years!");
        }
        return true;
    }

    public boolean isNameValid(String name){
        if(name==null || name.indexOf(" ")<0) {
            throw new IllegalArgumentException("We need both firstname and surename!");
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
