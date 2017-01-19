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
 * Created by Computer on 2017/1/17.
 */
@WebServlet(name = "ConAddServlet",urlPatterns = {"/ConAddServlet"})
public class ConAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
        //获取传过来的数据信息
        String name=request.getParameter("name");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        //封装进对象
        Contact c=new Contact();
        c.setName(name);
        c.setSex(sex);
        c.setPhone(phone);
        c.setEmail(email);
        c.setAddress(address);
//把数据保存到数据库
        ContactServlet conn=new ContactServletImpl();
try {
    conn.addContact(c);
}
catch (Exception e){
    request.setAttribute("mes",e.getMessage());
    //转发，回到添加联系人页面
    request.getRequestDispatcher("/addCon.jsp").forward(request,response);
}
//重定向，返回查看所有联系人页面
response.sendRedirect(request.getContextPath()+"/ConListServlet");
    }
}
