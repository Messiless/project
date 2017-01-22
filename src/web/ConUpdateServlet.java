package web;

import entity.Contact;
import service.ContactServlet;
import service.ContactServletImpl;
import util.BeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Computer on 2017/1/19.
 */
@WebServlet(name = "ConUpdateServlet",urlPatterns = "/ConUpdateServlet")
public class ConUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
          Contact contact = BeanUtil.getBean(request,Contact.class);
          ContactServlet conn=new ContactServletImpl();
          conn.updateContact(contact);
        request.getRequestDispatcher(request.getContextPath()+"/ConListServlet").forward(request,response);

    }
}
