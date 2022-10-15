package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.User;
import by.iba.kazakov.device_verification.repositories.UserRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public User save(User object) {
        return null;
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
