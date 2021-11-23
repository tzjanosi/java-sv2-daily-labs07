package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HumanTest {
    @Test
    void HumanTestOK(){
        Human human=new Human("John Doe",1901);
        assertEquals("John Doe",human.getName());
        assertEquals(1901,human.getYearOfBirth());
    }
    @Test
    void HumanTestNOK_name(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Human("JohnDoe",1976));
        assertEquals("We need both firstname and surename!", exception.getMessage());
    }
    @Test
    void HumanTestNOK_TooOld(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Human("John Doe",1900));
        assertEquals("The age should be below 120 years!", exception.getMessage());
    }

}