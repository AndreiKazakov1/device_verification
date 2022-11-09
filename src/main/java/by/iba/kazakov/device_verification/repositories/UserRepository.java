package by.iba.kazakov.device_verification.repositories;

import by.iba.kazakov.device_verification.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername (String username);
}