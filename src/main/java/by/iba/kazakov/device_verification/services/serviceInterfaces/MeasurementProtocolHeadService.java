package by.iba.kazakov.device_verification.services.serviceInterfaces;

import by.iba.kazakov.device_verification.models.MeasurementProtocolHead;

public interface MeasurementProtocolHeadService extends CrudService<MeasurementProtocolHead, Integer> {


    MeasurementProtocolHead findById(Long id);

    void currentProtocolId(Integer currProtocolId);

    void currentProtocolId(Long currProtocolId);

    Long returnCurrentProtocolId();

    void currentChannelsCount(Integer currChannelsCount);

    Integer returnCurrentChannelsCount();

    int[] channelArr();
}
