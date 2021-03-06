package service;

import demo.ContactDemo;
import demo.ContactDemoMysql;
import entity.Contact;

import java.util.List;

/**
 * Created by Computer on 2017/1/16.
 */
public class ContactServletImpl implements ContactServlet{
    //创建dao对象
    //ContactDao conDao = new ContactDaoImpl();
    ContactDemo conDao = new ContactDemoMysql();

    /**
     * 保存联系人
     * @throws
     */
    public void addContact(Contact contact) throws  Exception {
        //添加业务逻辑： 当姓名出现重复的时候，提示用户不能添加
        //检查用户名是否存在的
        if(conDao.checkNameExist(contact.getName())){
            //重复了，怎么办？  抛出自定义异常
            throw new   Exception("姓名重复，请重复输入");
        }
        conDao.addContact(contact);
    }

    public void deleteContact(String id) {
        conDao.deleteContact(id);
    }
    /**
     * 查询所有联系人
     */
    public List<Contact> findAll() {
        //如果有业务逻辑，把业务逻辑写在这里
        List<Contact> list = conDao.findAll();
        return list;
    }

    public Contact findById(String id) {

        return conDao.findById(id);
    }

    public void updateContact(Contact contact) {
        //可以在以后补充业务逻辑
        conDao.updateContact(contact);
    }
}
