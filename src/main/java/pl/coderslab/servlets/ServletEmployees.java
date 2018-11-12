package pl.coderslab.servlets;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletEmployees", urlPatterns = {"/employees"})
public class ServletEmployees extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name");
        String modname = request.getParameter("modname");

        if (name != null)
        {
            String surname = request.getParameter("surname");
            String street = request.getParameter("street");
            String number = request.getParameter("number");
            String city = request.getParameter("city");
            String phone = request.getParameter("phone");
            String note = request.getParameter("note");
            try {
                Double cost = Double.parseDouble(request.getParameter("cost"));
                EmployeeDao.insert(name, surname, street, number, city, phone, note, cost);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        else if( modname != null)
        {
            String modsurname = request.getParameter("modsurname");
            String modstreet = request.getParameter("modstreet");
            String modnumber = request.getParameter("modnumber");
            String modcity = request.getParameter("modcity");
            String modphone = request.getParameter("modphone");
            String modnote = request.getParameter("modnote");
            try
            {
                Double modcost = Double.parseDouble(request.getParameter("modcost"));
                long id = Long.parseLong(request.getParameter("id"));
                EmployeeDao.modify(id, modname, modsurname, modstreet, modnumber, modcity, modphone, modnote, modcost);
            }
            catch (NumberFormatException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                long delId = Long.parseLong(request.getParameter("delid"));
                EmployeeDao.deleteById(delId);
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
        request.setAttribute("empls", EmployeeDao.loadAll());
        getServletContext().getRequestDispatcher("/META-INF/views/employees.jsp").forward(request, response);
    }
}
