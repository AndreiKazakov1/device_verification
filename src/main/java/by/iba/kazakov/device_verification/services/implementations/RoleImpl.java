package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.Role;
import by.iba.kazakov.device_verification.repositories.RoleRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service

public class RoleImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Set<Role> findAll() {
        Set<Role>roles = new HashSet<>();
         roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public Role findById(Long aLong) {
        return null;
    }

    @Override
    public Role save(Role object) {
        return roleRepository.save(object);
    }

    @Override
    public void delete(Role object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Role findByName(String name){
        return roleRepository.findByName(name);
    }
}
