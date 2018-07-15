package com.pial.service;

import com.pial.spring.hibernate.pojo.User;
import com.pial.spring.hibernate.pojo.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean authenticator(String name, String password) {


        Resource r=new ClassPathResource("/webapp/WEB-INF/applicationContext.xml");
        BeanFactory factory=new XmlBeanFactory(r);
        System.out.println("name " + name + " password " + password);
        UserDao dao = (UserDao)factory.getBean("d");
        User user = new User(1, name, password);
        //dao.saveUser(user);*/

        boolean success = false;
        success = dao.containsUser(user);
        if(success == true) {
            return true;
        }
        return false;

    }
}