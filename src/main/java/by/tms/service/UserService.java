package by.tms.service;

import by.tms.dao.UserDao;
import by.tms.dao.UserDaoImp;
import by.tms.entity.User;
import by.tms.exeptions.user.InputDataUserException;
import by.tms.exeptions.user.UserDataException;
import by.tms.exeptions.user.UserException;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDaoImp();

    public void userRegister(String username, String fname,String lname, int age, String password) throws UserException {
        if (username == null || password == null){
            throw new InputDataUserException("Enter at least your username and password");
        }

        if (userDao.containsUsername(username)){
            throw new UserDataException("User already exist");
        }

        userDao.saveUser(new User(username,fname,lname,age,password));
    }

    public List<User> getUsersList() throws UserException {
        if (userDao.getUsers().isEmpty()){
            throw new UserDataException("There are no registered users in the system!");
        }
        return userDao.getUsers();
    }

    public User userSignIn(String username, String password) throws UserException {
        if (!userDao.containsUsernameAndPassword(username,password)){
            throw new InputDataUserException("Wrong username or password.\n" +
                    "Please enter both of your password and username correctly.");
        }

        return userDao.findUserByUsername(username);
    }
}
