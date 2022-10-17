package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();

          userService.createUsersTable();
          userService.dropUsersTable();
          userService.saveUser("Ольга", "Иванова", (byte) 25);
          userService.saveUser("Ксения", "Сидорова", (byte) 26);
          userService.saveUser("Петр", "Петров", (byte) 27);
          userService.saveUser("Юлия", "Васина", (byte) 28);
          userService.removeUserById(3);
          userService.getAllUsers();
          userService.cleanUsersTable();
    }

    }
