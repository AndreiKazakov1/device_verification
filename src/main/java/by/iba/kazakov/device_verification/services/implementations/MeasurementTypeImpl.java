package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.Client;
import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.repositories.ClientRepository;
import by.iba.kazakov.device_verification.repositories.MeasurementTypeRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.ClientService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MeasurementTypeImpl implements MeasurementTypeService {

    @Autowired
    MeasurementTypeRepository measurementTypeRepository;

    @Override
    public Set<MeasurementType> findAll() {
        Set<MeasurementType> measurementTypes = new HashSet<>();
        measurementTypeRepository.findAll().forEach(measurementTypes::add);
        return measurementTypes;
    }

    @Override
    public MeasurementType findById(Integer integer) {
        return null;
    }

    @Override
    public MeasurementType save(MeasurementType object) {

        return measurementTypeRepository.save(object);
    }

    @Override
    public void delete(MeasurementType object) {
    measurementTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
    measurementTypeRepository.deleteById(integer);
    }
}


/*
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public Set<Client> findAll() {
        Set<Client> clients = new HashSet<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }*/
