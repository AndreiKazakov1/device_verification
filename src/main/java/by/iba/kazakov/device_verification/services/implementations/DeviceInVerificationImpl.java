package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.DeviceInVerification;
import by.iba.kazakov.device_verification.repositories.DeviceInVerificationRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.DeviceInVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class DeviceInVerificationImpl implements DeviceInVerificationService {
    @Autowired
    DeviceInVerificationRepository deviceInVerificationRepository;
    @Override
    public Set<DeviceInVerification> findAll() {
        Set<DeviceInVerification> deviceInVerifications = new HashSet<>();
        deviceInVerificationRepository.findAll().forEach(deviceInVerifications::add);
        return deviceInVerifications;
    }

    @Override
    public DeviceInVerification findById(Integer integer) {
        return null;
    }

    @Override
    public DeviceInVerification save(DeviceInVerification object) {
        return deviceInVerificationRepository.save(object);
    }

    @Override
    public void delete(DeviceInVerification object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
