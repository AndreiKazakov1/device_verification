package by.iba.kazakov.device_verification.services.serviceInterfaces;

import by.iba.kazakov.device_verification.models.MeasurementProtocolHead;

public interface MeasurementProtocolHeadService extends CrudService<MeasurementProtocolHead, Integer> {


    void currentProtocolId(Integer currProtocolId);

    Integer returnCurrentProtocolId();

    void currentChannelsCount(Integer currChannelsCount);

    Integer returnCurrentChannelsCount();

    int[] channelArr();
}
