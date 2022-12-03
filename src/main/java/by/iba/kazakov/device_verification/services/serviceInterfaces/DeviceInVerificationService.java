package by.iba.kazakov.device_verification.services.serviceInterfaces;

import by.iba.kazakov.device_verification.models.DeviceInVerification;
import by.iba.kazakov.device_verification.services.serviceInterfaces.CrudService;

import java.util.Set;

public interface DeviceInVerificationService extends CrudService<DeviceInVerification, Integer> {
    DeviceInVerification findById(Long id);

    Set<DeviceInVerification> findAllDevicesByClientsId(Long clientsId);
}
