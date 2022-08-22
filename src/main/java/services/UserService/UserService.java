package services.UserService;

import entities.User;

public interface UserService {
    void save(User user);
    void delete(User user);
    void update(User user);
    User login(String username,String password);


}
