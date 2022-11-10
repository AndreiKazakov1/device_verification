package by.iba.kazakov.device_verification.repositories;



import by.iba.kazakov.device_verification.models.Role;
import by.iba.kazakov.device_verification.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository <Role, Long> {
    Role findByName (String name);
}
