package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.Standard;
import by.iba.kazakov.device_verification.repositories.StandardRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
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
    public Standard findById(Long id) {
        Set<Standard> standards = new HashSet<>();
        standardRepository.findAll().forEach(standards::add);
        for (Standard standard:standards){
            Long id_ = standard.getId();
            if (Objects.equals(id, id_)) return standard;
        }
        return null;
    }

    @Override
    public void deleteByIdLong(Long id) {
        standardRepository.deleteById(id);
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
