package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.PositiveResult;
import by.iba.kazakov.device_verification.repositories.PositiveResultRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.PositiveResultService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class PositiveResultImpl implements PositiveResultService {
    @Autowired
    PositiveResultRepository positiveResultRepository;
    @Override
    public Set<PositiveResult> findAll() {
        return null;
    }

    @Override
    public PositiveResult findById(Integer integer) {
        return null;
    }

    @Override
    public PositiveResult save(PositiveResult object) {
        return null;
    }

    @Override
    public void delete(PositiveResult object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
