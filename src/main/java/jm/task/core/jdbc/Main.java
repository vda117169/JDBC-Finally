package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.dropUsersTable();
        userDao.saveUser("Ольга", "Иванова", (byte) 25);
        userDao.saveUser("Ксения", "Сидорова", (byte) 26);
        userDao.saveUser("Петр", "Петров", (byte) 27);
        userDao.saveUser("Юлия", "Васина", (byte) 28);
        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
    }

    }
