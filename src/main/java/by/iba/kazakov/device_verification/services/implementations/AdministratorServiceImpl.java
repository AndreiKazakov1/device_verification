package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.Administrator;
import by.iba.kazakov.device_verification.models.Client;
import by.iba.kazakov.device_verification.repositories.AdministratorRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    AdministratorRepository administratorRepository;

    @Override
    public Set<Administrator> findAll() {
        Set<Administrator> administrators=new HashSet<>();
        administratorRepository.findAll().forEach(administrators ::add);
        return administrators;
    }




    @Override
    public Administrator findById(Integer integer) {
        return null;
    }

    @Override
    public Administrator save(Administrator object) {
        return administratorRepository.save(object);
    }

    @Override
    public void delete(Administrator object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }



}
