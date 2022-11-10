package by.iba.kazakov.device_verification.services.serviceInterfaces;

import by.iba.kazakov.device_verification.models.Role;

public interface RoleService extends CrudService<Role, Long>{
    Role findByName(String name);
}
