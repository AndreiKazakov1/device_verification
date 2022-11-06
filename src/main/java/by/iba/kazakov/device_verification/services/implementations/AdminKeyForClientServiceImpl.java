package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.AdminKeyForClient;
import by.iba.kazakov.device_verification.models.AdminKeyForVerifier;
import by.iba.kazakov.device_verification.repositories.AdminKeyForClientRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.AdminKeyForClientService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.AdminKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminKeyForClientServiceImpl implements AdminKeyForClientService {
    @Autowired
    AdminKeyForClientRepository adminKeyForClientRepository;

    @Override
    public Set<AdminKeyForClient> findAll() {
        Set<AdminKeyForClient> adminKeyForClients=new HashSet<>();
        adminKeyForClientRepository.findAll().forEach((adminKeyForClients ::add));
        return adminKeyForClients;
    }


    @Override
    public AdminKeyForClient findById(Integer integer) {
        return null;
    }

    @Override
    public AdminKeyForClient save(AdminKeyForClient object) {
        return null;
    }

    @Override
    public void delete(AdminKeyForClient object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
