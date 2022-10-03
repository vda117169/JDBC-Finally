package jm.task.core.jdbc;

import jm.task.core.jdbc.service.dao.UserDao;
import jm.task.core.jdbc.service.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
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
