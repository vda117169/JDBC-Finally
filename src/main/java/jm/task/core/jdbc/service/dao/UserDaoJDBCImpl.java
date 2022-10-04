package jm.task.core.jdbc.service.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static Connection connection;
    public UserDaoJDBCImpl() {
        connection = Util.getConnect();
        System.out.println("Connection successful!");

    }

    public void createUsersTable() {
        String createTable= "CREATE TABLE User (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(40), lastName VARCHAR(40), age INT(20))";

        try (
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String dropTable="DROP TABLE User";
        try (
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(dropTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        try (
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (name,LastName,age) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
             Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from User");
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
//                String name = resultSet.getString("name");
//                String lastName = resultSet.getString("lastName");
//                Byte age = resultSet.getByte("age");
                //users.add(new User(name, lastName, age));
                users.add(user);
            }
            System.out.println(users.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        String clean="TRUNCATE TABLE User";
        try (
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(clean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
