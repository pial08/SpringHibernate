package com.pial.spring.hibernate.pojo;

import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    HibernateTemplate template;
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    //method to save User
    public void saveUser(User u){
        template.save(u);
    }
    //method to update User
    public void updateUser(User u){
        template.update(u);
    }
    //method to delete User
    public void deleteUser(User u){
        template.delete(u);
    }
    //method to return one User of given id
    public User getById(int id){
        User u=(User)template.get(User.class,id);
        return u;
    }
    public boolean containsUser(User user) {
        return template.contains(user);

    }
    //method to return all Users
    public List<User> getUsers(){
        List<User> list=new ArrayList<User>();
        list=template.loadAll(User.class);
        return list;
    }
}
