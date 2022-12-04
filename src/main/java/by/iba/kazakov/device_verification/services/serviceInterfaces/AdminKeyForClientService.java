package by.iba.kazakov.device_verification.services.serviceInterfaces;

import by.iba.kazakov.device_verification.models.AdminKeyForClient;


public interface AdminKeyForClientService extends CrudService <AdminKeyForClient, Integer>{
    AdminKeyForClient findOnlyFirst();
}
