package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.AdminKey;
import by.iba.kazakov.device_verification.repositories.AdminKeyRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.AdminKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class AdminKeyServiceImpl implements AdminKeyService {
    @Autowired
    AdminKeyRepository adminKeyRepository;



    @Override
    public Set<AdminKey> findAll() {
        Set<AdminKey> adminKeys = new HashSet<>();
        adminKeyRepository.findAll().forEach(adminKeys::add);
        return adminKeys;

    }

    @Override
    public AdminKey findById(Integer integer) {return null;
    }

    @Override
    public AdminKey save(AdminKey object) {
        return null;
    }

    @Override
    public void delete(AdminKey object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
