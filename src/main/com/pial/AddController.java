package com.pial;


import com.pial.service.AddService;
import com.pial.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AddController {
    @Autowired
    AddService addService;
    @Autowired
    LoginService loginService;

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("hello world!!!");

        int x = Integer.parseInt(request.getParameter("t1"));
        int y = Integer.parseInt(request.getParameter("t2"));
        ModelAndView mv = new ModelAndView();
        AddService addService = new AddService();
        mv.setViewName("display.jsp");
        mv.addObject("result", addService.add(x, y));
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("username");
        String password = request.getParameter("pass");
        boolean loginSuccess = false;
        ModelAndView mv = new ModelAndView();
        mv.setViewName("display.jsp");
        LoginService loginService = new LoginService();
        if(loginService != null) {
            loginSuccess = loginService.authenticator(userName, password);
        }
        if(loginSuccess) {
            mv.addObject("result", "success");
        }
        else {
            mv.addObject("result", "failed");

        }

        return mv;
    }
}
