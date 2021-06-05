package com.example.servletDemo.service;

import com.example.servletDemo.dao.UserDaoImplement;
import com.example.servletDemo.entity.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserRegisterService extends HttpServlet {
    public void init(){

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        user.setUsername(request.getParameter("username"));
//        String sex = request.getParameter("sex");
//        sex = new String(sex.getBytes(""),"utf-8");
//        user.setSex(request.getParameter("sex"));
        user.setSex(new String(request.getParameter("sex").getBytes("ISO-8859-1"),"utf-8"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setId(20);
        userDaoImplement.insert(user);
        response.sendRedirect("index.jsp");
    }
}
