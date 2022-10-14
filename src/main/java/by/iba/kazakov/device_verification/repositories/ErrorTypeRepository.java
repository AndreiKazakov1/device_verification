package by.iba.kazakov.device_verification.repositories;

import by.iba.kazakov.device_verification.models.ErrorType;
import org.springframework.data.repository.CrudRepository;

public interface ErrorTypeRepository extends CrudRepository<ErrorType, Integer> {
}