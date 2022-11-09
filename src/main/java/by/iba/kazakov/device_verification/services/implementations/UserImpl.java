package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.User;
import by.iba.kazakov.device_verification.repositories.UserRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserImpl implements UserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long integer) {
        return null;
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public void deleteById(Long integer) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
