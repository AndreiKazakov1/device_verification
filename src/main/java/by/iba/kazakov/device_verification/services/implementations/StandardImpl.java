package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.Standard;
import by.iba.kazakov.device_verification.repositories.StandardRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class StandardImpl implements StandardService {
    @Autowired
    StandardRepository standardRepository;

    @Override
    public Set<Standard> findAll() {
        Set<Standard> standards = new HashSet<>();
        standardRepository.findAll().forEach(standards::add);
        return standards;
    }

    @Override
    public Standard findById(Integer integer) {
        return null;
    }

    @Override
    public Standard save(Standard object) {
        return standardRepository.save(object);
    }

    @Override
    public void delete(Standard object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
