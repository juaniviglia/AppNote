package AppNote.services.UserService;

import AppNote.entities.User;
import AppNote.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import AppNote.repositories.UserRepository;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        if(Optional.ofNullable(userRepository.findByUsernameAndPassword(username,password)).isPresent()){
            return userRepository.findByUsernameAndPassword(username,password);
        }else{
            throw new UserNotFoundException("The data entered does not match an existing user.");
        }
    }

    @Override
    public User findById(Integer idUser) {
        if(userRepository.findById(idUser).isPresent()){
            return userRepository.findById(idUser).get();
        }else{
            throw new UserNotFoundException("The ID does not match any User");
        }
    }
}
