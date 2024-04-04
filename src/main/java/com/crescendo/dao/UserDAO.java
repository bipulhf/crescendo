package com.crescendo.dao;

import com.crescendo.models.User;
import com.crescendo.models.UserPub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    DatabaseConnection db = new DatabaseConnection();

    public boolean addUser(User user) {
        boolean dataAdded = true;
        Connection con = db.getConnection();
        String sql = "INSERT INTO user (name, email, password, role) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            dataAdded = false;
            e.printStackTrace();
        }
        return dataAdded;
    }

    public UserPub login(String email, String password) {
        UserPub user = new UserPub();
        Connection con = db.getConnection();
        String sql = "SELECT name, email, role, id FROM user WHERE email=? AND password=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user.setName(rs.getString(1));
                user.setEmail(rs.getString(2));
                user.setRole(rs.getString(3));
                user.setID(Integer.parseInt(rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<UserPub> getUserList(String type) {
        Connection con = db.getConnection();
        List<UserPub> userList = new ArrayList<>();
        String sql = "SELECT ID, name, email, role FROM user WHERE role = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                userList.add(new UserPub(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
