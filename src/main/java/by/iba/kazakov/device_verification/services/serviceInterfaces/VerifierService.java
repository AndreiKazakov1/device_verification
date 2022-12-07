package by.iba.kazakov.device_verification.services.serviceInterfaces;

import by.iba.kazakov.device_verification.models.Verifier;
import by.iba.kazakov.device_verification.services.serviceInterfaces.CrudService;

public interface VerifierService
        extends CrudService<Verifier, Long> {

    Verifier findByUserId(Long id);

    Verifier findByFirstSecondName(String fn, String ln);

    boolean verServNumValidation(Integer verServiceNum);


    String isEnable(Long id);
}
