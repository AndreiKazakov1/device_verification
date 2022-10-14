package by.iba.kazakov.device_verification.repositories;

import by.iba.kazakov.device_verification.models.NegativeResult;
import org.springframework.data.repository.CrudRepository;

public interface NegativeResultRepository extends CrudRepository<NegativeResult, Integer> {
}