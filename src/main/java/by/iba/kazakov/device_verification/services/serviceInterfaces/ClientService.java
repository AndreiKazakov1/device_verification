package by.iba.kazakov.device_verification.services.serviceInterfaces;

import by.iba.kazakov.device_verification.models.Client;

public interface ClientService extends CrudService<Client, Integer> {

    Client findClientByUserId(Long id);

    boolean clientFileCodeValidation(Integer fileCodeNum);

    String isEnable(Long id);

    Client findById(Long id);
}
