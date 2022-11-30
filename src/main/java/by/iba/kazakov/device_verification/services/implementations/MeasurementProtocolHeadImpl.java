package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.MeasurementProtocolHead;
import by.iba.kazakov.device_verification.repositories.MeasurementProtocolHeadRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementProtocolHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Service
public class MeasurementProtocolHeadImpl implements MeasurementProtocolHeadService {
    @Autowired
    MeasurementProtocolHeadRepository measurementProtocolHeadRepository;

    @Override
    public Set<MeasurementProtocolHead> findAll() {
        Set<MeasurementProtocolHead> measurementProtocolHeads = new HashSet<>();
        measurementProtocolHeadRepository.findAll().forEach(measurementProtocolHeads::add);
        return measurementProtocolHeads;

    }

    @Override
    public MeasurementProtocolHead findById(Integer integer) {
        return null;
    }

    @Override
    public MeasurementProtocolHead findById(Long id) {
        Set<MeasurementProtocolHead> measurementProtocolHeads = new HashSet<>();
        measurementProtocolHeadRepository.findAll().forEach(measurementProtocolHeads::add);
        for (MeasurementProtocolHead measurementProtocolHead: measurementProtocolHeads) {
            Long findID = measurementProtocolHead.getId();
            if (Objects.equals(findID, id)) return measurementProtocolHead;
        }
        return null;
    }

    @Override
    public void currentProtocolId(Integer currProtocolId) {

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


    public static Long currentProtocolId;
    @Override
    public void currentProtocolId(Long currProtocolId){
        currentProtocolId = currProtocolId;
    }
    @Override
    public Long returnCurrentProtocolId(){
        return currentProtocolId;
    }


    public static int currentChannelsCount;
    @Override
    public void currentChannelsCount(Integer currChannelsCount){
        currentChannelsCount = currChannelsCount;
    }
    @Override
    public Integer returnCurrentChannelsCount(){
        return currentChannelsCount;
    }



    @Override
    public int[] channelArr(){
        int[] arr = new int[currentChannelsCount];
        for(int i = 1; i<currentChannelsCount; i++){
            arr[i]= i;
        }
        return arr;
    }


}
