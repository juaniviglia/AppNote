package AppNote.services.UserService;

import AppNote.entities.User;

public interface UserService {
    void save(User user);
    void delete(User user);
    void update(User user);
    User login(String username,String password);
    User findById(Integer idUser);

}
