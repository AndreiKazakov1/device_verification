package by.iba.kazakov.device_verification.repositories;

import by.iba.kazakov.device_verification.models.Administrator;
import by.iba.kazakov.device_verification.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface AdministratorRepository extends CrudRepository<Administrator, Integer> {

}