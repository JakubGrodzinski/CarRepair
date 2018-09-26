package pl.coderslab.dao;

import pl.coderslab.connector.DbUtil;
import pl.coderslab.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao
{
    public static List<Employee> loadAll ()
    {
        String query = "select * from employees";
        List<Employee> result = new ArrayList<>();
        try
        {
            Connection connection = DbUtil.getConn();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Employee tmp = new Employee();
                tmp.setId(resultSet.getLong("id"));
                tmp.setName(resultSet.getString("name"));
                tmp.setSurname(resultSet.getString("surname"));
                tmp.setStreet(resultSet.getString("street"));
                tmp.setnOfHouse(resultSet.getString("numberHouse"));
                tmp.setCity(resultSet.getString("city"));
                tmp.setPhoneNum(resultSet.getString("phonenum"));
                tmp.setNote(resultSet.getString("note"));
                tmp.setCost(resultSet.getDouble("cost"));
                result.add(tmp);
            }
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static Employee loadById (long id)
    {
        String query = "select * from employees where id = ?";
        Employee result = new Employee();
        try
        {
            Connection connection = DbUtil.getConn();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                result.setId(resultSet.getLong("id"));
                result.setName(resultSet.getString("name"));
                result.setSurname(resultSet.getString("surname"));
                result.setStreet(resultSet.getString("street"));
                result.setnOfHouse(resultSet.getString("numberHouse"));
                result.setCity(resultSet.getString("city"));
                result.setPhoneNum(resultSet.getString("phonenum"));
                result.setNote(resultSet.getString("note"));
                result.setCost(resultSet.getDouble("cost"));
                connection.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static void modify (long id, String name, String surname, String street, String nOfHouse, String city, String phoneNum, String note, Double cost)
    {
        String query = "update employees set name=?, surname=?, street=?, numberHouse=?, city=?, phonenum=?, note=?, cost=? where id=?";
        try
        {
            Connection connection = DbUtil.getConn();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, street);
            preparedStatement.setString(4, nOfHouse);
            preparedStatement.setString(5, city);
            preparedStatement.setString(6, phoneNum);
            preparedStatement.setString(7, note);
            preparedStatement.setDouble(8, cost);
            preparedStatement.setLong(9, id);
            preparedStatement.executeUpdate();
            connection.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void deleteById(long id)
    {
        String query = "delete from employees where id=?";
        try
        {
            Connection connection = DbUtil.getConn();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void insert (String name, String surname, String street, String nOfHouse, String city, String phoneNum, String note, Double cost)
    {
        String query = "insert into employees (id ,name, surname, street, numberHouse, city, phonenum, note, cost) values (null, ?, ?, ?, ?, ?, ?, ?, ?)";
        try
        {
            Connection connection = DbUtil.getConn();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, street);
            preparedStatement.setString(4, nOfHouse);
            preparedStatement.setString(5, city);
            preparedStatement.setString(6, phoneNum);
            preparedStatement.setString(7, note);
            preparedStatement.setDouble(8, cost);
            preparedStatement.executeUpdate();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
