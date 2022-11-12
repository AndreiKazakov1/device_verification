package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.DeviceType;
import by.iba.kazakov.device_verification.models.Standard;
import by.iba.kazakov.device_verification.repositories.DeviceTypeRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class DeviceTypeImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeRepository deviceTypeRepository;
    @Override
    public Set<DeviceType> findAll() {
        Set<DeviceType> deviceTypes = new HashSet<>();
        deviceTypeRepository.findAll().forEach(deviceTypes::add);
        return deviceTypes;
    }



    @Override
    public DeviceType findById(Integer integer) {
        return null;
    }

    @Override
    public DeviceType save(DeviceType object) {
        return deviceTypeRepository.save(object);
    }




    @Override
    public void delete(DeviceType object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
