package web;

import entity.Contact;
import org.apache.commons.beanutils.BeanUtils;
import service.ContactServlet;
import service.ContactServletImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Computer on 2017/1/19.
 */
@WebServlet(name = "ConUpdateServlet",urlPatterns = "/ConUpdateServlet")
public class ConUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        */
      try {
          Map map=request.getParameterMap();

          Contact contact = new Contact();
          BeanUtils.copyProperties(contact,map);
          ContactServlet conn=new ContactServletImpl();
          conn.updateContact(contact);
      }
       catch (Exception e){
           e.printStackTrace();
       }
       /* contact.setId(id);
        contact.setName(name);
        contact.setSex(sex);
        contact.setPhone(phone);
        contact.setEmail(email);
        contact.setAddress(address);
        */
        request.getRequestDispatcher(request.getContextPath()+"/ConListServlet").forward(request,response);

    }
}
