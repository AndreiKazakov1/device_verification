package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.AdminKeyForVerifier;
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
    public Set<AdminKeyForVerifier> findAll() {
        Set<AdminKeyForVerifier> adminKeyForVerifiers = new HashSet<>();
        adminKeyRepository.findAll().forEach(adminKeyForVerifiers::add);
        return adminKeyForVerifiers;

    }

    @Override
    public AdminKeyForVerifier findById(Integer integer) {return null;
    }

    @Override
    public AdminKeyForVerifier save(AdminKeyForVerifier object) {
        return null;
    }

    @Override
    public void delete(AdminKeyForVerifier object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
