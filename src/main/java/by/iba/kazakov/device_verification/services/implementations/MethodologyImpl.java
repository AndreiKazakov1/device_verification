package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.Methodology;
import by.iba.kazakov.device_verification.repositories.MethodologyRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MethodologyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MethodologyImpl implements MethodologyService {
    @Autowired
    MethodologyRepository methodologyRepository;

    @Override
    public Set<Methodology> findAll() {
        return null;
    }

    @Override
    public Methodology findById(Integer integer) {
        return null;
    }

    @Override
    public Methodology save(Methodology object) {
        return methodologyRepository.save(object);
    }

    @Override
    public void delete(Methodology object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}


    /*@Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }
*/