package pl.coderslab.servlets;

import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ServletOrders", urlPatterns = {"/orders"})
public class ServletOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        java.sql.Date reception = Date.valueOf(request.getParameter("reception"));
        if(reception != null)
        {
            String problem = request.getParameter("problem");
            String solution = request.getParameter("solution");
            try
            {
                Double partscost = Double.parseDouble(request.getParameter("partscost"));
                Double empmhourquantity = Double.parseDouble(request.getParameter("emphourquantity"));
                OrderDao.insert(reception, problem, solution, partscost, empmhourquantity);
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
        request.setAttribute("orders", OrderDao.loadAll());
        getServletContext().getRequestDispatcher("/META-INF/views/orders.jsp").forward(request, response);
    }
}
