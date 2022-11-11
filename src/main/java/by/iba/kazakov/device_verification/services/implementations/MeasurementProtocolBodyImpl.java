package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.MeasurementProtocolBody;
import by.iba.kazakov.device_verification.repositories.MeasurementProtocolBodyRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementProtocolBodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class MeasurementProtocolBodyImpl implements MeasurementProtocolBodyService {
    @Autowired
    MeasurementProtocolBodyRepository measurementProtocolBodyRepository;
    @Override
    public Set<MeasurementProtocolBody> findAll() {
        return null;
    }

    @Override
    public MeasurementProtocolBody findById(Integer integer) {
        return null;
    }

    @Override
    public MeasurementProtocolBody save(MeasurementProtocolBody object) {
        return null;
    }

    @Override
    public void delete(MeasurementProtocolBody object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
