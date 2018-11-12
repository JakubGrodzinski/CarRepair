package pl.coderslab.servlets;

import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ServletVehicles", urlPatterns = {"/vehicles"})
public class ServletVehicles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String model = request.getParameter("model");
        if(model != null)
        {
            String make = request.getParameter("make");
            try
            {
                int year = Integer.parseInt(request.getParameter("year"));
                String regNumber = request.getParameter("regnumber");
                java.sql.Date servicing = Date.valueOf(request.getParameter("nextservicing"));
                VehicleDao.insert(model, make, year, regNumber, servicing);
            }
            catch (NumberFormatException e)
            {
                e.printStackTrace();
            }
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("vehicles", VehicleDao.loadAll());
        getServletContext().getRequestDispatcher("/META-INF/views/vehicles.jsp").forward(request, response);
    }
}
