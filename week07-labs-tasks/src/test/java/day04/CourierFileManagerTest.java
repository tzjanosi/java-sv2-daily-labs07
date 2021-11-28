package day04;

import day01.Human;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CourierFileManagerTest {
    CourierFileManager courierFileManager=new CourierFileManager();
    @Test
    void CourierFileManagerTestOK(){
        Courier courier=courierFileManager.createCourierByFile(Paths.get("src/main/resources/futar.txt"));
        assertEquals(4,courier.getRides().get(5).getDay());
        assertEquals(3,courier.getRides().get(5).getNoOfRide());
        assertEquals(9,courier.getRides().get(5).getDistance());
    }
    @Test
    void CourierFileManagerTestNOK_order(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> courierFileManager.createCourierByFile(Paths.get("src/main/resources/futarNOK.txt")));
        assertEquals("Problem with the record order!", exception.getMessage());
    }
    @Test
    void CourierFileManagerTestNOK_NOFile(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> courierFileManager.createCourierByFile(Paths.get("src/main/resources/futar69.txt")));
         assertTrue(exception.getMessage().startsWith("Can not read file:"));
    }
}