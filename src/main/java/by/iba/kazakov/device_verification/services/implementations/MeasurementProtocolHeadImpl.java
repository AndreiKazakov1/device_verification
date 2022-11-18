package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.MeasurementProtocolHead;
import by.iba.kazakov.device_verification.repositories.MeasurementProtocolHeadRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementProtocolHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
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
        return measurementProtocolHeadRepository.save(object);
    }

    @Override
    public void delete(MeasurementProtocolHead object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
