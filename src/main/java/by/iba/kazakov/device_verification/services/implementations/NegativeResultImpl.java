package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.NegativeResult;
import by.iba.kazakov.device_verification.repositories.NegativeResultRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.NegativeResultService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class NegativeResultImpl implements NegativeResultService {
    @Autowired
    NegativeResultRepository negativeResultRepository;
    @Override
    public Set<NegativeResult> findAll() {
        return null;
    }

    @Override
    public NegativeResult findById(Integer integer) {
        return null;
    }

    @Override
    public NegativeResult save(NegativeResult object) {
        return null;
    }

    @Override
    public void delete(NegativeResult object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
