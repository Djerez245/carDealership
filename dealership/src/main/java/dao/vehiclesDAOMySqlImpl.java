package dao;

import com.pluralsight.Vehicle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class vehiclesDAOMySqlImpl implements vehiclesDAO {

    DataSource dataSource;

    public vehiclesDAOMySqlImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public ArrayList<Vehicle> findVehicleByMake(String make) {
        ArrayList<Vehicle> vehicleByMake = new ArrayList<>();
        int vin;
        int year;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE make = ?;
                    """);

            statement.setString(1, make);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                model = rs.getString("model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicleByMake.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByMake;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByModel(String model) {
        ArrayList<Vehicle> vehicleByModel = new ArrayList<>();
        int vin;
        int year;
        String make;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE model = ?;
                    """);

            statement.setString(1, model);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicleByModel.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByModel;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByColor(String color) {
        ArrayList<Vehicle> vehicleByColor = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE color = ?;
                    """);

            statement.setString(1, color);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("model");
                vehicleType = rs.getString("type");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicleByColor.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByColor;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByVin(int vin) {
        ArrayList<Vehicle> vehicleByVin = new ArrayList<>();
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE vin = ?;
                    """);

            statement.setInt(1, vin);
            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicleByVin.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByVin;
    }

    @Override
    public ArrayList<Vehicle> findVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> vehicleByType = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE type = ?;
                    """);

            statement.setString(1, vehicleType);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("model");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicleByType.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByType;
    }

    @Override
    public ArrayList<Vehicle> findVehiclesByPriceRange(double minPrice, double maxPrice) {
        ArrayList<Vehicle> vehicleByPrice = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE price BETWEEN ? AND ?;
                    """);

            statement.setDouble(1, minPrice);
            statement.setDouble(2, maxPrice);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicleByPrice.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByPrice;
    }

    @Override
    public ArrayList<Vehicle> findVehiclesByMileage(int minOdometer, int maxOdometer) {
        ArrayList<Vehicle> vehicleByMileage = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?;
                    """);

            statement.setDouble(1, minOdometer);
            statement.setDouble(2, maxOdometer);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicleByMileage.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByMileage;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByYear(int year) {
        ArrayList<Vehicle> vehicleByYear = new ArrayList<>();
        int vin;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE year = ?;
                    """);

            statement.setInt(1, year);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicleByYear.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByYear;
    }

    @Override
    public void addVehicle(){

    }

    @Override
    public void removeVehicle() {

    }


}
