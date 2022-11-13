package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.DeviceType;
import by.iba.kazakov.device_verification.models.MeasurementChannelType;
import by.iba.kazakov.device_verification.repositories.MeasurementChannelTypeRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementChannelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class MeasurementChannelTypeImpl implements MeasurementChannelTypeService {
    @Autowired
    MeasurementChannelTypeRepository measurementChannelTypeRepository;
    @Override
    public Set<MeasurementChannelType> findAll() {
        Set<MeasurementChannelType> measurementChannelTypes= new HashSet<>();
        measurementChannelTypeRepository.findAll().forEach(measurementChannelTypes::add);
        return measurementChannelTypes;
    }


    @Override
    public MeasurementChannelType findById(Integer integer) {
        return null;
    }

    @Override
    public MeasurementChannelType save(MeasurementChannelType object) {
        return measurementChannelTypeRepository.save(object);
    }

    @Override
    public void delete(MeasurementChannelType object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
