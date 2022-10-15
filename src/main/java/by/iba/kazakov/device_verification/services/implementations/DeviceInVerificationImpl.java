package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.DeviceInVerification;
import by.iba.kazakov.device_verification.repositories.DeviceInVerificationRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.DeviceInVerificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class DeviceInVerificationImpl implements DeviceInVerificationService {
    @Autowired
    DeviceInVerificationRepository deviceInVerificationRepository;
    @Override
    public Set<DeviceInVerification> findAll() {
        return null;
    }

    @Override
    public DeviceInVerification findById(Integer integer) {
        return null;
    }

    @Override
    public DeviceInVerification save(DeviceInVerification object) {
        return null;
    }

    @Override
    public void delete(DeviceInVerification object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
