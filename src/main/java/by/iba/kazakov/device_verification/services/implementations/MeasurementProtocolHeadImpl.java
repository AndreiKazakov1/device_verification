package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.MeasurementProtocolHead;
import by.iba.kazakov.device_verification.repositories.MeasurementProtocolHeadRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementProtocolHeadService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MeasurementProtocolHeadImpl implements MeasurementProtocolHeadService {
    @Autowired
    MeasurementProtocolHeadRepository measurementProtocolHeadRepository;
    @Override
    public Set<MeasurementProtocolHead> findAll() {
        return null;
    }

    @Override
    public MeasurementProtocolHead findById(Integer integer) {
        return null;
    }

    @Override
    public MeasurementProtocolHead save(MeasurementProtocolHead object) {
        return null;
    }

    @Override
    public void delete(MeasurementProtocolHead object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
