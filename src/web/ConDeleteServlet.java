package web;

import service.ContactServlet;
import service.ContactServletImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Computer on 2017/1/19.
 */
@WebServlet(name = "ConDeleteServlet" ,urlPatterns ="/ConDeleteServlet")
public class ConDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String id=request.getParameter("id");
        ContactServlet conn=new ContactServletImpl();
        conn.deleteContact(id);
        response.sendRedirect(request.getContextPath()+"/ConListServlet");

    }
}
