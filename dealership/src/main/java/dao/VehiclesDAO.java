package dao;

import com.pluralsight.Vehicle;

import java.util.ArrayList;

public interface VehiclesDAO {
    public ArrayList<Vehicle> findVehicleByMake(String make);
    public ArrayList<Vehicle> findVehicleByModel(String model);
    public ArrayList<Vehicle> findVehicleByColor(String color);
    public ArrayList<Vehicle> findVehicleByVin(int vin);
    public ArrayList<Vehicle> findVehiclesByType(String type);
    public ArrayList<Vehicle> findVehiclesByPriceRange(double minPrice, double maxPrice);
    public ArrayList<Vehicle> findVehiclesByMileage(int minOdometer, int maxOdometer);
    public ArrayList<Vehicle> findVehicleByYear(int year);
    public void addVehicle(Vehicle v);
    public void removeVehicle(int vin);
}
