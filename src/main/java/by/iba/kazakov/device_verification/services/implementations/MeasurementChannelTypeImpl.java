package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.MeasurementChannelType;
import by.iba.kazakov.device_verification.repositories.MeasurementChannelTypeRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementChannelTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MeasurementChannelTypeImpl implements MeasurementChannelTypeService {
    @Autowired
    MeasurementChannelTypeRepository measurementChannelTypeRepository;
    @Override
    public Set<MeasurementChannelType> findAll() {
        return null;
    }

    @Override
    public MeasurementChannelType findById(Integer integer) {
        return null;
    }

    @Override
    public MeasurementChannelType save(MeasurementChannelType object) {
        return null;
    }

    @Override
    public void delete(MeasurementChannelType object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
