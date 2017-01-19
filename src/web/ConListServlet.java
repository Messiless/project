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
        import java.util.List;

/**
 * Created by Computer on 2017/1/17.
 */
@WebServlet(name = "ConListServlet",urlPatterns ="/ConListServlet")
public class ConListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将数据库的数据读取出来
        ContactServlet conn=new ContactServletImpl();
        ContactServlet conList=new ContactServletImpl();
        List<Contact> list=conList.findAll();
        //把数据放到域对象中
        request.setAttribute("conList",conList);
       //转发
        request.getRequestDispatcher("/listCon.jsp").forward(request,response);
    }
}
