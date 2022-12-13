package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.Verifier;
import by.iba.kazakov.device_verification.repositories.UserRepository;
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
    @Autowired
    UserRepository userRepository;

    @Override
    public Set<Verifier> findAll() {
        Set<Verifier> verifiers = new HashSet<>();
        verifierRepository.findAll().forEach(verifiers::add);
        return verifiers;
    }

    @Override
    public Verifier findById(Long id) {
        Set<Verifier> verifiers = new HashSet<>();
        verifierRepository.findAll().forEach(verifiers::add);
        for(Verifier verifier: verifiers){
            Long verId = verifier.getId();
            if (Objects.equals(verId, id)) return verifier;
        }
        return  null;
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
        verifierRepository.delete(object);

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

    @Override
    public String isEnable(Long id){
        Set<Verifier> verifiers = new HashSet<>();
        verifierRepository.findAll().forEach(verifiers::add);
        Verifier verifier_ = new Verifier();
        String activity = "";
        for(Verifier verifier:verifiers){
            Long id_ = verifier.getIdUser().getId();
            if (Objects.equals(id_, id))verifier_=verifier;
        }
           boolean isEnable = verifier_.getIdUser().isEnabled();
           if (isEnable) activity = "активен";
           else activity = "заблокирован";
           return activity;

    }


}


