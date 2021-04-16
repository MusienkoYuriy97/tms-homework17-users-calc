package by.tms.dao;

import by.tms.entity.User;
import by.tms.exeptions.user.UserException;
import by.tms.exeptions.user.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao{
    private static List<User> users = new ArrayList<>();

    public List<User> getUsers() throws UserException {
        return new ArrayList<>(users);
    }

    public void saveUser(User user) throws UserException {
        users.add(user);
    }

    public boolean containsUsername(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean containsUsernameAndPassword(String username, String password){
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public User findUserByUsername(String username) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }
}
