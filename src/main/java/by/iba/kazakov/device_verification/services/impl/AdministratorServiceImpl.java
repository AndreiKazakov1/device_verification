package by.iba.kazakov.device_verification.services.impl;

import by.iba.kazakov.device_verification.models.Administrator;
import by.iba.kazakov.device_verification.repositories.AdministratorRepository;
import by.iba.kazakov.device_verification.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    AdministratorRepository administratorRepository;

    @Override
    public Set<Administrator> findAll() {
        return null;
    }

    @Override
    public Administrator findById(Integer integer) {
        return null;
    }

    @Override
    public Administrator save(Administrator object) {
        return null;
    }

    @Override
    public void delete(Administrator object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
