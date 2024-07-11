package dao;

import model.User;

import java.util.HashMap;

public class UserDao {

    private static UserDao userDaoInstance = null;

    private User currentLoginUser;

    private UserDao() {
        currentLoginUser = null;
    }

    public static UserDao getInstance() {
        if (userDaoInstance == null)
            userDaoInstance = new UserDao();

        return userDaoInstance;
    }

    public User getCurrentLoginUser() {
        return currentLoginUser;
    }

    public void setCurrentLoginUser(User currentLoginUser) {
        this.currentLoginUser = currentLoginUser;
    }
}
