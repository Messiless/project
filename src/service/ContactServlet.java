package service;

import entity.Contact;

import java.util.List;

/**
 * Created by Computer on 2017/1/16.
 */
public interface ContactServlet {
    public void addContact(Contact contact) throws Exception;
    public void updateContact(Contact contact);  //包含修改的id
    public void deleteContact(String id);
    public List<Contact> findAll();
    public Contact findById(String id); //根据id查询对应的联系人
}
