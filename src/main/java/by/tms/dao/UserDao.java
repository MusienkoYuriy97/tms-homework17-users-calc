package by.tms.dao;

import by.tms.entity.User;
import by.tms.exeptions.user.UserException;
import java.util.List;

public interface UserDao {
    List<User> getUsers() throws UserException;
    void saveUser(User user) throws UserException;
    boolean containsUsername(String username);
    boolean containsUsernameAndPassword(String username, String password);
    User findUserByUsername(String username) throws UserException;
}
