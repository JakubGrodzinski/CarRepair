package pl.coderslab.dao;

import pl.coderslab.connector.DbUtil;
import pl.coderslab.model.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehicleDao
{
    public static List<Vehicle> loadAll()
    {
        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "select * from vehicles";
        try (Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getLong("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setRegNumber(resultSet.getString("regnumber"));
                vehicle.setNext(resultSet.getDate("next"));
                vehicle.setCustomer(CustomerDao.getCustomerById(resultSet.getLong("customer_id")));
                vehicleList.add(vehicle);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return vehicleList;
    }

    public static Vehicle loadById(Long id)
    {
        Vehicle vehicle = new Vehicle();
        String query = "select * from vehicles where id=?";
        try (Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                vehicle.setId(resultSet.getLong("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setMake(resultSet.getString("make"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setRegNumber(resultSet.getString("regnumber"));
                vehicle.setNext(resultSet.getDate("date"));
                vehicle.setCustomer(CustomerDao.getCustomerById(resultSet.getLong("customer_id")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return vehicle;
    }

    public static void insert (String model, String make, int year, String regNumber, Date next)
    {
        String query = "insert into vehicles (id, model, make, year, regnumber, next) values (null, ?, ?, ?, ?,?)";
        try(Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, model);
            preparedStatement.setString(2, make);
            preparedStatement.setInt(3, year);
            preparedStatement.setString(4, regNumber);
            preparedStatement.setDate(5, (java.sql.Date)next);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void modify (Long id, String model, String make, int year, String regNumber, Date next)
    {
        String query = "update vehicles set model=?, make=?, year=?, regnumber=?, next=? where id=?";
        try(Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, model);
            preparedStatement.setString(2, make);
            preparedStatement.setInt(3, year);
            preparedStatement.setString(4, regNumber);
            preparedStatement.setDate(5, (java.sql.Date)next);
            preparedStatement.setLong(6, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
