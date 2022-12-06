package by.iba.kazakov.device_verification.services.serviceInterfaces;

import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.services.serviceInterfaces.CrudService;

public interface MeasurementTypeService extends CrudService<MeasurementType, Integer> {
    MeasurementType findById(Long id);

    void deleteById(Long id);
}
