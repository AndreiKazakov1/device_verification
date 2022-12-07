package by.iba.kazakov.device_verification.services.serviceInterfaces;

import by.iba.kazakov.device_verification.models.User;

public interface UserService extends CrudService<User, Long> {

    Long findByName(String name);

    String findPassByName(String name);

    boolean loginValidation(String login);

    boolean oldClientsPassValidation(String pass, Long currentClientsId);

    boolean twoClientsPassEquals(String clientsNewPass, String clientsNewPassSubmit);


}
