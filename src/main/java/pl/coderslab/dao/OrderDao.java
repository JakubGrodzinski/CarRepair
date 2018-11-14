package pl.coderslab.dao;

import pl.coderslab.connector.DbUtil;
import pl.coderslab.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao
{
    public static List<Order> loadAll ()
    {
        String query = "select * from orders";
        List<Order> result = new ArrayList<>();
        try (Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Order order = new Order();
                order.setId(resultSet.getLong("id"));
                order.setReception(resultSet.getDate("reception"));
                order.setPlannedStart(resultSet.getDate("planstart"));
                order.setActualStart(resultSet.getDate("actstart"));
                order.setAssignedEmployee(EmployeeDao.loadById(resultSet.getLong("employee_id")));
                order.setDescriptionProblem(resultSet.getString("descprob"));
                order.setDescriptionSolution(resultSet.getString("descsol"));
                order.setVehicle(VehicleDao.loadById(resultSet.getLong("veh_id")));
                order.setTotalCost(resultSet.getDouble("totalcost"));
                order.setPartsCosts(resultSet.getDouble("partscost"));
                order.setEmpHourCost(resultSet.getDouble("employeehourcost"));
                order.setEmpHoursQuantity(resultSet.getDouble("employeehourquantity"));
                order.setStatus(StatusDao.loadById(resultSet.getLong("status_id")));
                result.add(order);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static Order loadById (Long id)
    {
        Order order = new Order();
        String query = "select * from orders where id=?";
        try(Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                order.setId(resultSet.getLong("id"));
                order.setReception(resultSet.getDate("reception"));
                order.setPlannedStart(resultSet.getDate("planstart"));
                order.setActualStart(resultSet.getDate("actstart"));
                order.setAssignedEmployee(EmployeeDao.loadById(resultSet.getLong("employee_id")));
                order.setDescriptionProblem(resultSet.getString("descprob"));
                order.setDescriptionSolution(resultSet.getString("descsol"));
                order.setVehicle(VehicleDao.loadById(resultSet.getLong("veh_id")));
                order.setTotalCost(resultSet.getDouble("totalcost"));
                order.setPartsCosts(resultSet.getDouble("partscost"));
                order.setEmpHourCost(resultSet.getDouble("employeehourcost"));
                order.setEmpHoursQuantity(resultSet.getDouble("employeehourquantity"));
                order.setStatus(StatusDao.loadById(resultSet.getLong("status_id")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return order;
    }

    public static void insert (java.sql.Date reception, java.sql.Date planStart, java.sql.Date actStart, String descProb, String descSol, Double partsCost, Double empQuantity)
    {
        String query = "insert into orders (id, reception, planstart, actstart, descprob, descsol, partscost, employeehourquantity) values (null, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, reception);
            preparedStatement.setDate(2, planStart);
            preparedStatement.setDate(3, actStart);
            preparedStatement.setString(4, descProb);
            preparedStatement.setString(5, descSol);
            preparedStatement.setDouble(6, partsCost);
            preparedStatement.setDouble(7, empQuantity);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void modify (Long id, java.sql.Date reception, java.sql.Date planStart, java.sql.Date actStart, String descProb, String descSol, Double partsCost, Double empQuantity)
    {
        String query = "update orders set reception=?, planstart=?, actstart=?, descprob=?, descsol=?, partscost=?, employeehourquantity=? where id=?";
        try(Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, reception);
            preparedStatement.setDate(2, planStart);
            preparedStatement.setDate(3, actStart);
            preparedStatement.setString(4, descProb);
            preparedStatement.setString(5, descSol);
            preparedStatement.setDouble(6, partsCost);
            preparedStatement.setDouble(7, empQuantity);
            preparedStatement.setLong(8, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void delete (Long id)
    {
        String query = "delete from orders where id=?";
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

    public static void assignEmployee (Long order_id, long employee_id)
    {
        String query = "update orders set employee_id=? where id=?";
        try(Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, employee_id);
            preparedStatement.setLong(2, order_id);
            // TO DO - connect employee with his cost and total cost
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
