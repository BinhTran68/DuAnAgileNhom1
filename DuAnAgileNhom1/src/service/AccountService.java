/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;

/**
 *
 * @author admin
 */
public class AccountService {

    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private String sql = null;

    public User findUserByUserName(String userName) {

        User user = null;

        connection = DBConnect.getConnection();

        sql = "select id, username, password, hoVaTen, role from nguoiDung where username = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User(resultSet.getString("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("hoVaTen"), resultSet.getString("role"));

            }

            return user;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();

            } catch (Exception e) {
            }
        }
        return user;

    }

    public int registerUser(User user) {

        int kq = 0;

        try {
            sql = "insert into nguoiDung(username,password,hoVaTen,gioiTinh,role) "
                    + " values (?,?,?,?,?)";

            connection = DBConnect.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getHoVaTen());
            preparedStatement.setBoolean(4, true);
            preparedStatement.setString(5, user.getQuyen());

            kq = preparedStatement.executeUpdate();

            return kq;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;

    }

    public User dangNhap(String username, String pass) {

        sql = "select id, username, password, hoVaTen, role from nguoiDung where username = ? and  = ?";
        
        User user = null;
        
        connection = DBConnect.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pass);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User(resultSet.getString("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("hoVaTen"), resultSet.getString("role"));
            }
            
            return  user;

        } catch (Exception e) {
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  user;

    }

}
