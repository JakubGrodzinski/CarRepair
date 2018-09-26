package pl.coderslab.dao;

import pl.coderslab.connector.DbUtil;
import pl.coderslab.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao
{
    public static List<Customer> getAllCustomers ()
    {
        List<Customer> result = new ArrayList<>();
        String query = "select * from customers";
        try(Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Customer tmp = new Customer();
                tmp.setId(resultSet.getLong("id"));
                tmp.setName(resultSet.getString("name"));
                tmp.setSurname(resultSet.getString("surname"));
                tmp.setDateOfBirth(resultSet.getDate("birth"));
                result.add(tmp);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    public static Customer getCustomerById (long id)
    {
        Customer result = new Customer();
        String query = "select * from customers where id=?";
        try(Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                result.setId(resultSet.getLong("id"));
                result.setName(resultSet.getString("name"));
                result.setSurname(resultSet.getString("surname"));
                result.setDateOfBirth(resultSet.getDate("birth"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static void addCustomer (String name, String surname, java.sql.Date dateOfBirth)
    {
        String query = "insert into customers (id, name, surname, birth) values (null, ?, ?, ?)";
        try (Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setDate(3, dateOfBirth);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void modify (long id, String name, String surname, java.sql.Date dateOfBirth)
    {
        String query = "update customers set name=?, surname=?, birth=? where id=?";
        try (Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setDate(3, dateOfBirth);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void delete (long id)
    {
        String query = "delete from customers where id=?";
        try (Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
