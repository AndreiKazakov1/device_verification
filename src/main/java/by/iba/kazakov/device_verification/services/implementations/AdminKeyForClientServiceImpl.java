package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.AdminKeyForClient;
import by.iba.kazakov.device_verification.repositories.AdminKeyForClientRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.AdminKeyForClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
    public AdminKeyForClient findOnlyFirst() {
        Set<AdminKeyForClient> adminKeyForClients=new HashSet<>();
        adminKeyForClientRepository.findAll().forEach((adminKeyForClients ::add));

        for (AdminKeyForClient adminKeyForClient:adminKeyForClients){
            Long id = adminKeyForClient.getId();
            AdminKeyForClient adminKeyForClient1;
            if (id == 1) {
                adminKeyForClient1 = adminKeyForClient;
                return adminKeyForClient1;
            }
        }
        return null;
    }

    @Override
    public AdminKeyForClient findById(Integer integer) {
        return null;
    }

    @Override
    public AdminKeyForClient save(AdminKeyForClient object) {
        return adminKeyForClientRepository.save(object);
    }

    @Override
    public void delete(AdminKeyForClient object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
