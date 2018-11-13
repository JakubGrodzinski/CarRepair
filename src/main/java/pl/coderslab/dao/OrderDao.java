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
}
