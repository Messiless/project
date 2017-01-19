package demo;

import entity.Contact;

import java.util.List;

/**
 * Created by Computer on 2017/1/16.
 */
public interface ContactDemo {
    //添加联系人
    public void addContact(Contact con);
    //修改联系人信息
    public void updateContact(Contact con);
    //删除联系人
    public void deleteContact(String id);
    //查看所有联系人
    public List<Contact> findAll();
    //根据id查联系人
    public Contact findById(String id);
    //检查姓名是否重复
    public boolean checkNameExist(String name);
}
