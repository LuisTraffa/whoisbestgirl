package com.lvt.waifuranker.repositories;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.lvt.waifuranker.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private Connection connection;

    public UserRepository() {
        try {


            System.out.println("Loading database...");
            connection = DriverManager.getConnection("jdbc:sqlite:./Database");
            System.out.println("Connection to SQLite has been established.");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getUserList() {

        List<User> users = new ArrayList<>();

        try {

            String select = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);

            while (resultSet.next()) {

                users.add(new User(resultSet.getString("username"), resultSet.getString("password"), resultSet.getLong("waifulist")));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;

    }

    public User getUserByUsername(String username) {

        User user = null;
        try {

            String select = "SELECT * FROM users WHERE username = '" + username + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);

            while (resultSet.next()) {
                user = new User(resultSet.getString("username"), resultSet.getString("password"), resultSet.getLong("id"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {
            System.out.println("User " + username + " not found");
            return null;
        }
        return user;

    }

    public void addUser(User user) {

        System.out.println(user.getUsername() + user.getPassword());
        try {
            String insert = "INSERT INTO users (username, password) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "')";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateUser(User user) {

        try {
            String update = "UPDATE users SET password = '" + user.getPassword() + "', waifulist = " + user.getWaifuList() + " WHERE username = '" + user.getUsername() + "'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {

        try {
            UserRepository ur = new UserRepository();
            ur.connection.createStatement().executeUpdate("INSERT INTO users VALUES ('luist', 'Skynet', 0)");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
