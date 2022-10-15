package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.DeviceInVerificationMeasurementChannel;
import by.iba.kazakov.device_verification.repositories.DeviceInVerificationMeasurementChannelRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.DeviceInVerificationMeasurementChannelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class DeviceInVerificationMeasurementChannelImpl implements DeviceInVerificationMeasurementChannelService {
    @Autowired
    DeviceInVerificationMeasurementChannelRepository deviceInVerificationMeasurementChannelRepository;
    @Override
    public Set<DeviceInVerificationMeasurementChannel> findAll() {
        return null;
    }

    @Override
    public DeviceInVerificationMeasurementChannel findById(Integer integer) {
        return null;
    }

    @Override
    public DeviceInVerificationMeasurementChannel save(DeviceInVerificationMeasurementChannel object) {
        return null;
    }

    @Override
    public void delete(DeviceInVerificationMeasurementChannel object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
