package com.example.servletDemo.service;

import com.example.servletDemo.dao.UserDaoImplement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectUserService extends HttpServlet {
    public void init(){
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        System.out.println(userDaoImplement.selecteAll().toString());
        request.getSession().setAttribute("userlist",userDaoImplement.selecteAll());
        response.sendRedirect("index.jsp");
    }

    public void destroy(){

    }
}
