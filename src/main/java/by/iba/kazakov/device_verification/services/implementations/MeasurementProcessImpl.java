package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.MeasurementProcess;
import by.iba.kazakov.device_verification.repositories.MeasurementProcessRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementProcessService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MeasurementProcessImpl implements MeasurementProcessService {
    @Autowired
    MeasurementProcessRepository measurementProcessRepository;
    @Override
    public Set<MeasurementProcess> findAll() {
        return null;
    }

    @Override
    public MeasurementProcess findById(Integer integer) {
        return null;
    }

    @Override
    public MeasurementProcess save(MeasurementProcess object) {
        return null;
    }

    @Override
    public void delete(MeasurementProcess object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
