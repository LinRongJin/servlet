package com.example.servletDemo.dao;

import com.example.servletDemo.entity.User;
import com.example.servletDemo.util.DataBaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplement implements UserDao{

    @Override
    public void insert(User user) {
         String sql = "insert into user values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = DataBaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getSex());
            preparedStatement.setInt(4,user.getAge());
            int state = preparedStatement.executeUpdate();
            System.out.println("insert state : "+state);
        } catch (SQLException throwables) {
            System.out.println("insert fail");
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        String sql = "update user set ";
    }

    @Override
    public void delete(User user) {
        try {
            if (user.getId() != 0) {

            }
            PreparedStatement preparedStatement = DataBaseConnection.getConnection().prepareStatement("delete from user where id = ?");
            preparedStatement.setInt(1,user.getId());
            int state = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public User selectByUsername(String username) {
        return null;
    }

    @Override
    public List<User> selecteAll() {
        List<User> userList = new ArrayList<User>();
        String sql = "select * from user user,score score where user.id = score.id";
        try {
            ResultSet resultSet = DataBaseConnection.getConnection().prepareStatement(sql).executeQuery();
            User user = null;
            while (resultSet.next()){
                user = new User();
                user.setUser(resultSet.getInt("id"),resultSet.getString("username")
                        ,resultSet.getString("sex"),resultSet.getInt("age"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            System.out.println("发送sql语句异常");
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> selectUser(User user) {
        String sql = null;
        if (user.getId() != 0) {
            sql="select * from user where id ="+user.getId();
        }else if (user.getSex() != null) {
            sql="select  * from user where sex = "+user.getSex();
        }else if (user.getUsername() != null){
            sql = "select * from user where username = "+user.getUsername();
        }else if (user.getAge() != 0){
            sql = "select * from USER where age ="+user.getAge();
        }else {
            System.out.println("parameter error");
        }
        List<User> userList = new ArrayList<User>();
        try {
            PreparedStatement preparedStatement = DataBaseConnection.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user1 = null;
            while (resultSet.next()){
                user = new User();
                user.setUser(resultSet.getInt("id"),resultSet.getString("username")
                        ,resultSet.getString("sex"),resultSet.getInt("age"));
                userList.add(user1);
                user = null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    //paging query
    @Override
    public List<User> getTotal(int start, int num) {
        String sql = "select * from user order by id  limit ? , ?";
        List<User> userList = new ArrayList<User>();
        try {
            PreparedStatement preparedStatement = DataBaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,start);
            preparedStatement.setInt(2,num);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while(resultSet.next()){
                user = new User();
                user.setUser(resultSet.getInt("id"),resultSet.getString("username")
                        ,resultSet.getString("sex"),resultSet.getInt("age"));
                userList.add(user);
                user = null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }
}
