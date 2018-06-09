package lyaMur.dao.daoConnector;

import lyaMur.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoUser {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    private static List<User> userList = new ArrayList<User>();

    public static void connectToUsers() throws SQLException {
        connection = DriverManager.getConnection("jdbs:mysql://tt62008f7lbsry1x:kueqt32c8snffxff@lt80glfe2gj8p5n2.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/hytxwnavkj1qz6g4");
        System.out.println("Connection to Table 'Users' is OK");
    }

    public static void createTableUsers() throws SQLException {
        statement = connection.createStatement();
        statement.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY NOT NULL, 'user_name' TEXT, 'password' TEXT, 'status' TEXT);)");
        System.out.println("Table 'users' are created");
    }

    public static List<User> getUserByName(String name) throws SQLException {
        resultSet = statement.executeQuery("select password status FROM 'users' WHERE user_name=" + name+";");
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String userName = resultSet.getString("user_name");
            String password = resultSet.getString("password");
            String status = resultSet.getString("status");

            User user = new User();
            user.setId(id);
            user.setName(userName);
            user.setPassword(password);
            user.setStatus(status);
            userList.add(user);
        }
        return userList;
    }

    public static void close() throws SQLException {
        statement.close();
        connection.close();
    }

}
