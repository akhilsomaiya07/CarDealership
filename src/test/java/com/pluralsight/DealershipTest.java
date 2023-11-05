package com.pluralsight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class DealershipTest {

    private Dealership dealership;

    @BeforeEach
    public void setUp() {
        this.dealership = new Dealership("test", "test address", "test phone#");
        this.dealership.addVehicle(new Vehicle(1, 2020, "Toyota", "Camry", "Sedan", "Red", 10000, 20000.0));
        this.dealership.addVehicle(new Vehicle(2, 2021, "Honda", "Civic", "Sedan", "Blue", 8000, 25000.0));
        this.dealership.addVehicle(new Vehicle(3, 2022, "Ford", "F-150", "Truck", "Black", 15000, 30000.0));
    }

    @Test
    public void testGetVehicleByPriceWithinRange() {
        // Arrange
        double minPrice = 20000.0;
        double maxPrice = 30000.0;

        // Act
        List<Vehicle> filteredArray = dealership.getVehiclesByPrice(minPrice, maxPrice);

        // Assert
        for (Vehicle vehicle : filteredArray) {
            assertTrue(vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice);
            if(vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) System.out.println(vehicle);
        }
    }

    @Test
    public void testGetVehicleByPriceNoMatch() {
        // Arrange
        double minPrice = 40000.0;
        double maxPrice = 45000.0;

        // Act
        List<Vehicle> filteredArray = dealership.getVehiclesByPrice(minPrice, maxPrice);

        // Assert
        assertTrue(filteredArray.isEmpty());
    }

    @Test
    public void testGetVehicleByMakeModelMatch() {
        // Arrange
        String make = "Ford";
        String model = "F-150";

        // Act
        List<Vehicle> filteredArray = dealership.getVehiclesByMakeModel(make, model);

        // Assert
        for (Vehicle vehicle : filteredArray) {
            assertTrue(vehicle.getMake().equalsIgnoreCase(make) || vehicle.getModel().equalsIgnoreCase(model));
            if(vehicle.getMake().equalsIgnoreCase(make) || vehicle.getModel().equalsIgnoreCase(model)) System.out.println(vehicle);
        }
    }

    @Test
    public void testGetVehicleByMakeModelNoMatch() {
        // Arrange
        String make = "Chevrolet";
        String model = "Malibu";

        // Act
        List<Vehicle> filteredArray = dealership.getVehiclesByMakeModel(make, model);

        // Assert
        assertTrue(filteredArray.isEmpty());

    }

    @Test
    public void testGetVehicleByYearWithinRange() {
        // Arrange
        int minYear = 2020;
        int maxYear = 2021;

        // Act
        List<Vehicle> filteredArray = dealership.getVehiclesByYear(minYear, maxYear);

        // Assert
        for (Vehicle vehicle : filteredArray) {
            assertTrue(vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear);
            if(vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear) System.out.println(vehicle);
        }
    }

    @Test
    public void testGetVehicleByYearNoMatch() {
        // Arrange
        int minYear = 2019;
        int maxYear = 2019;

        // Act
        List<Vehicle> filteredArray = dealership.getVehiclesByYear(minYear, maxYear);

        // Assert
        assertTrue(filteredArray.isEmpty());
    }

    @Test
    public void testGetVehicleByMakeModelWithMultipleMatches() {
        // Arrange
        String make = "Toyota";
        String model = "Camry";

        // Act
        List<Vehicle> filteredArray = dealership.getVehiclesByMakeModel(make, model);

        // Assert
        for (Vehicle vehicle : filteredArray) {
            assertTrue(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model));
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) System.out.println(vehicle);
        }
    }

    @Test
    public void testGetVehicleByMakeModelCaseInsensitive() {
        // Arrange
        String make = "HONDA"; // Uppercase
        String model = "civic"; // Lowercase

        // Act
        List<Vehicle> filteredArray = dealership.getVehiclesByMakeModel(make, model);

        // Assert
        for (Vehicle vehicle : filteredArray) {
            assertTrue(vehicle.getMake().equalsIgnoreCase(make) || vehicle.getModel().equalsIgnoreCase(model));
            if(vehicle.getMake().equalsIgnoreCase(make) || vehicle.getModel().equalsIgnoreCase(model)) System.out.println(vehicle);
        }
    }
}