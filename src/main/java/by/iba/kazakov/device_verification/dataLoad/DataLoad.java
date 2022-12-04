package by.iba.kazakov.device_verification.dataLoad;

import by.iba.kazakov.device_verification.models.*;
import by.iba.kazakov.device_verification.services.serviceInterfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class DataLoad implements CommandLineRunner {
    @Autowired
    RoleService roleService;

    @Autowired
    AdminKeyForVerifierService adminKeyService;

    @Autowired
    AdminKeyForClientService adminKeyForClientService;

    @Autowired
    AdministratorService administratorService;

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        int countRoles = roleService.findAll().size();
        int countVerKey = adminKeyService.findAll().size();
        int countClientKey = adminKeyForClientService.findAll().size();
        int countUsers = userService.findAll().size();
        if (countRoles == 0) setRoles();
        if (countVerKey == 0) setVerKey();
        if (countClientKey == 0) setClientKey();
        if (countUsers == 0) setAdmin();


    }

    public void setRoles(){
        roleService.save(new Role("ROLE_ADMIN"));
        roleService.save(new Role("ROLE_VERIFIER"));
        roleService.save(new Role("ROLE_CLIENT"));

    }

    public  void setVerKey(){
        adminKeyService.save(new AdminKeyForVerifier("1111"));
    }

    public void setClientKey(){
        adminKeyForClientService.save(new AdminKeyForClient("2222"));
    }

    public void setAdmin(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword(BCrypt.hashpw("100",BCrypt.gensalt(12)));
        user.setRoles( new ArrayList<>());
        user.getRoles().add(roleService.findByName("ROLE_ADMIN"));
        user.getRoles().add(roleService.findByName("ROLE_VERIFIER"));
        user.getRoles().add(roleService.findByName("ROLE_CLIENT"));
        userService.save(user);
        Administrator administrator = new Administrator();
        administrator.setIdUser(user);
        administrator.setAdminFirstName("Andrei");
        administrator.setAdminLastName("Kazakov");
        administratorService.save(administrator);
    }


}
