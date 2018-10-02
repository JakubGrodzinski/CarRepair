package pl.coderslab.servlets;

import pl.coderslab.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ServletCustomers", urlPatterns = {"/customers"})
public class ServletCustomers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String addName = request.getParameter("name");
        String modifyName = request.getParameter("modifyName");
        if(addName != null)
        {
            String addSurname = request.getParameter("surname");
            java.sql.Date addDate = Date.valueOf(request.getParameter("date"));
            CustomerDao.addCustomer(addName, addSurname, addDate);
        }
        else if(modifyName != null)
        {
            long modifyId = Long.parseLong(request.getParameter("modifyId"));
            String modifySurname = request.getParameter("modifySurname");
            java.sql.Date modifyDate = Date.valueOf(request.getParameter("modifyDate"));
            CustomerDao.modify(modifyId, modifyName, modifySurname, modifyDate);
        }
        else
        {
            long delId = Long.parseLong(request.getParameter("delId"));
            CustomerDao.delete(delId);
        }
        request.setAttribute("customers", CustomerDao.getAllCustomers());
        getServletContext().getRequestDispatcher("/META-INF/views/customers.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("customers", CustomerDao.getAllCustomers());
        getServletContext().getRequestDispatcher("/META-INF/views/customers.jsp").forward(request, response);
    }
}
