package by.iba.kazakov.device_verification.dataLoad;

import by.iba.kazakov.device_verification.models.Role;
import by.iba.kazakov.device_verification.services.serviceInterfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoad implements CommandLineRunner {
    @Autowired
    RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        int count = roleService.findAll().size();
        if (count == 0) setRoles();
    }

    public void setRoles(){
        roleService.save(new Role("ROLE_ADMIN"));
        roleService.save(new Role("ROLE_VERIFIER"));
        roleService.save(new Role("ROLE_CLIENT"));

    }


}
