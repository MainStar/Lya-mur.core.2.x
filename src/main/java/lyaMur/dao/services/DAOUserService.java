package lyaMur.dao.services;


import lyaMur.User;
import lyaMur.dao.daoConnector.DaoUser;

import java.sql.SQLException;
import java.util.List;

public class DAOUserService {

    private DaoUser daoUser = new DaoUser();
    private List<User> users;

    private String verification;

    public String verifyUser(String name, String password) throws SQLException {

        daoUser.connectToUsers();
        daoUser.createTableUsers();
        users = daoUser.getUserByName(name);
        for (User el : users){
            if (el.getName().equals(name) && el.getPassword().equals(password)){
                if (el.getStatus().equals("admin")){
                    verification = "valid";
                }else {
                    verification = "invalid";
                }
            }else{
                verification = "invalid";
            }
        }
        daoUser.close();
        return verification;
    }

}
