package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.ErrorType;
import by.iba.kazakov.device_verification.repositories.ErrorTypeRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.ErrorTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ErrorTypeImpl implements ErrorTypeService {
    @Autowired
    ErrorTypeRepository errorTypeRepository;
    @Override
    public Set<ErrorType> findAll() {
        return null;
    }

    @Override
    public ErrorType findById(Integer integer) {
        return null;
    }

    @Override
    public ErrorType save(ErrorType object) {
        return null;
    }

    @Override
    public void delete(ErrorType object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
