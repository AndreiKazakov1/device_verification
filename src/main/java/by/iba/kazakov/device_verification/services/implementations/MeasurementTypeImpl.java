package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.repositories.MeasurementTypeRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MeasurementTypeImpl implements MeasurementTypeService {
    @Autowired
    MeasurementTypeRepository measurementTypeRepository;
    @Override
    public Set<MeasurementType> findAll() {
        return null;
    }

    @Override
    public MeasurementType findById(Integer integer) {
        return null;
    }

    @Override
    public MeasurementType save(MeasurementType object) {
        return null;
    }

    @Override
    public void delete(MeasurementType object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
