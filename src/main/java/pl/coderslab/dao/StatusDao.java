package pl.coderslab.dao;

import pl.coderslab.connector.DbUtil;
import pl.coderslab.model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDao
{
    public static Status loadById (Long id)
    {
        Status result = new Status();
        String query = "select * from statuses where id=?";
        try (Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                result.setId(resultSet.getLong("id"));
                result.setStat(resultSet.getString("description"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Status> loadAll ()
    {
        List<Status> result = new ArrayList<>();
        String query = "select * from statuses";
        try(Connection connection = DbUtil.getConn())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Status status =new Status();
                status.setId(resultSet.getLong("id"));
                status.setStat(resultSet.getString("description"));
                result.add(status);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}

