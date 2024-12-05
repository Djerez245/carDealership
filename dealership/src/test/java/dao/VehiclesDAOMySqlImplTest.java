package dao;

import com.pluralsight.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehiclesDAOMySqlImplTest {

    static BasicDataSource ds = new BasicDataSource();

    @BeforeAll
    static void setup(){
        ds.setUsername("root");
        ds.setUrl("jdbc:mysql://localhost:3306/cardealership");
        ds.setPassword("yearup");
    }

    @AfterAll
    static void tearDown(){
        try {
            ds.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @org.junit.jupiter.api.Test
    void test_findVehicleByMake() {
        VehiclesDAO vehiclesDAO = new VehiclesDAOMySqlImpl(ds);
        int expectedNumOfVehicles = 1 ;

        List<Vehicle> results = vehiclesDAO.findVehicleByMake("honda");
        assertEquals(expectedNumOfVehicles, results.size());
    }

    @Test
    void findVehicleByModel() {
        VehiclesDAO vehiclesDAO = new VehiclesDAOMySqlImpl(ds);
        int expectedNumOfVehicles = 1 ;

        List<Vehicle> results = vehiclesDAO.findVehicleByModel("accord");
        assertEquals(expectedNumOfVehicles, results.size());
    }

    @Test
    void findVehicleByColor() {
        VehiclesDAO vehiclesDAO = new VehiclesDAOMySqlImpl(ds);
        int expectedNumOfVehicles = 2 ;

        List<Vehicle> results = vehiclesDAO.findVehicleByColor("black");
        assertEquals(expectedNumOfVehicles, results.size());
    }

    @Test
    void findVehicleByVin() {
        VehiclesDAO vehiclesDAO = new VehiclesDAOMySqlImpl(ds);
        int expectedNumOfVehicles = 1 ;

        List<Vehicle> results = vehiclesDAO.findVehicleByVin(12345);
        assertEquals(expectedNumOfVehicles, results.size());
    }

    @Test
    void findVehiclesByType() {
        VehiclesDAO vehiclesDAO = new VehiclesDAOMySqlImpl(ds);
        int expectedNumOfVehicles = 4 ;

        List<Vehicle> results = vehiclesDAO.findVehiclesByType("sedan");
        assertEquals(expectedNumOfVehicles, results.size());
    }

    @Test
    void findVehiclesByPriceRange() {
        VehiclesDAO vehiclesDAO = new VehiclesDAOMySqlImpl(ds);
        int expectedNumOfVehicles = 3 ;
        double minPrice = 900.;
        double maxPrice = 10000.;

        List<Vehicle> results = vehiclesDAO.findVehiclesByPriceRange(minPrice, maxPrice);
        assertEquals(expectedNumOfVehicles, results.size());
    }

    @Test
    void findVehiclesByMileage() {
        VehiclesDAO vehiclesDAO = new VehiclesDAOMySqlImpl(ds);
        int expectedNumOfVehicles = 4 ;
        int minOdometer = 1000;
        int maxOdometer = 10000;


        List<Vehicle> results = vehiclesDAO.findVehiclesByMileage(minOdometer, maxOdometer);
        assertEquals(expectedNumOfVehicles, results.size());
    }

    @Test
    void findVehicleByYear() {
        VehiclesDAO vehiclesDAO = new VehiclesDAOMySqlImpl(ds);
        int expectedNumOfVehicles = 3 ;

        List<Vehicle> results = vehiclesDAO.findVehicleByYear(2024);
        assertEquals(expectedNumOfVehicles, results.size());
    }

}