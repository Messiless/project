package demo;

import entity.Contact;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Computer on 2017/1/16.
 */
public class ContactDemoMysql implements ContactDemo {
    @Override
    public void addContact(Contact con) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "insert into just4(name,sex,phone,email,address)values(?,?,?,?,?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, con.getName());
            stm.setString(2, con.getSex());
            stm.setString(3, con.getPhone());
            stm.setString(4, con.getEmail());
            stm.setString(5, con.getAddress()
            );
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.show(stm, conn);
        }
    }

    @Override
    public void updateContact(Contact con) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "UPDATE just4 set NAME =?, sex=?, phone=?, email=?, address=? where id=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, con.getName());
            stm.setString(2, con.getSex());
            stm.setString(3, con.getPhone());
            stm.setString(4, con.getEmail());
            stm.setString(5, con.getAddress());
            stm.setString(6,con.getId());

            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.show(stm, conn);
        }

    }

    @Override
    public void deleteContact(String id) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "DELETE  FROM just4 where id=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.show(stm, conn);
        }
    }

    @Override
    public List<Contact> findAll() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT*from just4 ";
            stm = conn.prepareStatement(sql);
            res = stm.executeQuery();
            List<Contact> list = new ArrayList<Contact>();
            while (res.next()) {
                Contact c = new Contact();
                c.setId(res.getString("id"));
                c.setName(res.getString("name"));
                c.setSex(res.getString("sex"));
                c.setPhone(res.getString("phone"));
                c.setEmail(res.getString("email"));
                c.setAddress(res.getString("address"));
                list.add(c);
            }
            return  list;
        } catch (Exception e) {

        } finally {
            JdbcUtil.show(res, stm, conn);
        }
        return null;
    }

    @Override
    public Contact findById(String id) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        Contact c1 = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT*FROM just4 where id=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            res = stm.executeQuery();
            if (res.next()) {
                c1 = new Contact();
                c1.setId(res.getString("id"));
                c1.setName(res.getString("name"));
                c1.setSex(res.getString("sex"));
                c1.setPhone(res.getString("phone"));
                c1.setEmail(res.getString("email"));
                c1.setAddress(res.getString("address"));
            }
            return c1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.show(res, stm, conn);
        }

    }



    @Override
    public boolean checkNameExist(String name) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet res=null;
try {
    conn=JdbcUtil.getConnection();
    String sql="select*from just4 where name=?";
    stm=conn.prepareStatement(sql);
    stm.setString(1,name);
    res=stm.executeQuery();
    return res.next();
}
catch (Exception e){
    throw new RuntimeException(e);
}
finally {
    JdbcUtil.show(res,stm,conn);
}

    }
}
