package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.Verifier;
import by.iba.kazakov.device_verification.repositories.VerifierRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.VerifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
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
    public Verifier findById(Long id) {
        return new Verifier();
    }


    public Verifier findByUserId(Long id){
        Set<Verifier> verifiers = new HashSet<>();
        verifierRepository.findAll().forEach(verifiers::add);
        for (Verifier verifier:verifiers) {
            Long idUser = verifier.getIdUser().getId();
            if (Objects.equals(id, idUser)) return verifier;
        }
        return null;
    }

    @Override
    public Verifier findByFirstSecondName(String fn, String ln){
        Set<Verifier> verifiers = new HashSet<>();
        verifierRepository.findAll().forEach(verifiers::add);
        for (Verifier verifier:verifiers){
            String fn_=verifier.getVerifierFirstName();
            String ln_=verifier.getVerifierLastName();
            if((Objects.equals(fn_, fn))&&(Objects.equals(ln_, ln)))return verifier;
        }
        return null;
    }

    @Override
    public Verifier save(Verifier object) {return  verifierRepository.save(object);
    }

    @Override
    public void delete(Verifier object) {

    }

    @Override
    public void deleteById(Long id) {

    }


    @Override
    public boolean verServNumValidation(Integer verServiceNum) {
        Set<Verifier> verifiers = new HashSet<>();
        verifierRepository.findAll().forEach(verifiers::add);
        for (Verifier verifier:verifiers) {
            Integer servNumForValid = verifier.getVerifierServiceNumber();
            if(Objects.equals(servNumForValid, verServiceNum)) return false;
        }
       return true;
    }



}


