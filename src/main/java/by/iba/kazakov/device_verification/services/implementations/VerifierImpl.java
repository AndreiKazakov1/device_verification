package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.AdminKey;
import by.iba.kazakov.device_verification.models.Client;
import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.models.Verifier;
import by.iba.kazakov.device_verification.repositories.AdminKeyRepository;
import by.iba.kazakov.device_verification.repositories.VerifierRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.VerifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class VerifierImpl implements VerifierService {
    @Autowired
    VerifierRepository verifierRepository;

    @Override
    public Set<Verifier> findAll() {
        Set<Verifier> verifiers = new HashSet<>();
        verifierRepository.findAll().forEach(verifiers::add);
        return verifiers;
    }

    @Override
    public Verifier findById(Integer integer) {
        return null;
    }

    @Override
    public Verifier save(Verifier object) {return  verifierRepository.save(object);
    }

    @Override
    public void delete(Verifier object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }



}


