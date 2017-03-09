package web;

import entity.Contact;
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
@WebServlet(name = "ConQueryServlet",urlPatterns = "/ConQueryServlet")
public class ConQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受传过来的参数
         String id=request.getParameter("id");

        //得到Contact对象
        ContactServlet conn=new ContactServletImpl();
        Contact con=conn.findById(id);
        //把数据发到jsp页面
        request.setAttribute("con",con);
        request.getRequestDispatcher("/editCon.jsp").forward(request,response);

    }
}
