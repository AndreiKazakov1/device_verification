package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.Client;
import by.iba.kazakov.device_verification.models.ErrorType;
import by.iba.kazakov.device_verification.repositories.ErrorTypeRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.ErrorTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class ErrorTypeImpl implements ErrorTypeService {
    @Autowired
    ErrorTypeRepository errorTypeRepository;
    @Override
    public Set<ErrorType> findAll() {
        Set<ErrorType>errorTypes = new HashSet<>();
        errorTypeRepository.findAll().forEach(errorTypes::add);
        return errorTypes;
    }


    @Override
    public ErrorType findById(Integer integer) {
        return null;
    }

    @Override
    public ErrorType save(ErrorType object) {
        return errorTypeRepository.save(object);
    }

    @Override
    public void delete(ErrorType object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
