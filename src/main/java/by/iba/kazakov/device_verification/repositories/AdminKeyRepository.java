package by.iba.kazakov.device_verification.repositories;

import by.iba.kazakov.device_verification.models.AdminKeyForVerifier;
import org.springframework.data.repository.CrudRepository;

public interface AdminKeyRepository extends CrudRepository<AdminKeyForVerifier, Integer> {
}