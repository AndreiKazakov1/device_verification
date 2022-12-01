package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.Role;
import by.iba.kazakov.device_verification.models.User;
import by.iba.kazakov.device_verification.repositories.UserRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }


    @Override
    public User findById(Long userId) {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        for (User user: users){
            Long id = user.getId();
            if(Objects.equals(userId, id)) return user;
        }
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

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }


    @Override
    @Transactional()
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(),
        true, true,true,
        mapRolesToAuthorities(user.getRoles()));
    }

        private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        }

    @Override
    public Long findByName(String name) {
        return userRepository.findByUsername(name).getId();
    }

    @Override
    public String findPassByName(String name){return  userRepository.findByUsername(name).getPassword();}



    @Override
    public boolean loginValidation(String login) {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        for (User user : users) {
            String loginForValidation = user.getUsername();
            if (Objects.equals(loginForValidation, login)) return false;
        } return true;
    }

    @Override
    public boolean oldClientsPassValidation(String pass, Long currentClientsId) {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        for (User user : users) {
            Long id = user.getId();
            if (Objects.equals(currentClientsId, id)) {
                String oldPass = user.getPassword();
                return BCrypt.checkpw(pass, oldPass);
            }return false;
        }
        return false;
    }


    @Override
    public boolean twoClientsPassEquals(String clientsNewPass, String clientsNewPassSubmit){
        return Objects.equals(clientsNewPass, clientsNewPassSubmit);
    }

}
