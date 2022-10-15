package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.Standart;
import by.iba.kazakov.device_verification.repositories.StandartRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.StandartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class StandartImpl implements StandartService {
    @Autowired
    StandartRepository standartRepository;
    @Override
    public Set<Standart> findAll() {
        return null;
    }

    @Override
    public Standart findById(Integer integer) {
        return null;
    }

    @Override
    public Standart save(Standart object) {
        return null;
    }

    @Override
    public void delete(Standart object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
