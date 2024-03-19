package com.oline.store.dao.dto;

import com.oline.store.dao.DBConnection;
import com.oline.store.dao.RoleDao;
import com.oline.store.dao.UserDao;
import com.oline.store.dao.impl.UserContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Persistence implements UserDao, DBConnection {

    PreparedStatement stmt = null;
    int rowsAffected = 0;
    private RoleDao roleDao;

    @Override
    public UserContainer getUserById(int id) {

        try {
            var conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM user WHERE id = ?");

            stmt.setInt(1, id);

            try (var readStatement = stmt.executeQuery()) {
                if (readStatement.next()) {
                    UserContainer user = new UserContainer();
                    user.setId(readStatement.getInt("id"));
                    user.setName(readStatement.getString("first_name"));
                    user.setSurname(readStatement.getString("last_name"));
                    user.setEmail(readStatement.getString("email"));
                    user.setRole(roleDao.getRoleById(readStatement.getInt("fk_user_role")));
                    user.setMoney(readStatement.getBigDecimal("money"));
                    user.setCreditCard(readStatement.getString("credit_card"));
                    return user;
                }
            }


            rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " row(s) affected");

            // Close the statement and connection
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    @Override
    public UserContainer getUserByEmail(String email) {
        try {
            var conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM user WHERE email = ?");

            stmt.setString(1, email);

            try (var readStatement = stmt.executeQuery()) {
                if (readStatement.next()) {
                    UserContainer user = new UserContainer();
                    user.setId(readStatement.getInt("id"));
                    user.setName(readStatement.getString("first_name"));
                    user.setSurname(readStatement.getString("last_name"));
                    user.setEmail(readStatement.getString("email"));
                    user.setRole(roleDao.getRoleById(readStatement.getInt("fk_user_role")));
                    user.setMoney(readStatement.getBigDecimal("money"));
                    user.setCreditCard(readStatement.getString("credit_card"));
                    return user;
                }
            }


            rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " row(s) affected");

            // Close the statement and connection
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void saveUser(UserContainer user) {
        try {
            var conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO user (first_name, last_name, email, fk_user_role, "
                    + "money, credit_card) VALUES (?, ?, ?, ?, ?, ?);");

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            stmt.setString(3, user.getEmail());
            if (user.getRole() != null) {
                stmt.setInt(4, user.getRole().getId());
            } else {
                stmt.setNull(4, java.sql.Types.NULL);
            }

            stmt.setBigDecimal(5,user.getMoney());
            stmt.setString(6, user.getCreditCard());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    @Override
    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME, USERNAME, PASSWORD);
            System.out.println("Connected to database: " + DB_NAME);
            return connection;
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database. Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
