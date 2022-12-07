package by.iba.kazakov.device_verification.services.implementations;

import by.iba.kazakov.device_verification.models.Client;
import by.iba.kazakov.device_verification.repositories.ClientRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public Set<Client> findAll() {
        Set<Client> clients = new HashSet<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    @Override
    public Client findById(Integer id) {
        return new Client();
    }

    @Override
    public Client save(Client object) {
        return clientRepository.save(object);
    }

    @Override
    public void delete(Client object) {
    clientRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Client findClientByUserId(Long id){
        Set<Client> clients = new HashSet<>();
        clientRepository.findAll().forEach(clients::add);
        for(Client client:clients){
            Long idUser = client.getIdUser().getId();
            if(Objects.equals(id, idUser))return client;
        }
        return null;
    }

    @Override
    public boolean clientFileCodeValidation(Integer fileCodeNum) {
        Set<Client> clients = new HashSet<>();
        clientRepository.findAll().forEach(clients::add);
        for (Client client:clients) {
            Integer fileCodeNumForValid = client.getClientFileCode();
            if(Objects.equals(fileCodeNumForValid, fileCodeNum)) return false;
        }
        return true;
    }

    @Override
    public String isEnable(Long id){
        Set<Client> clients = new HashSet<>();
        clientRepository.findAll().forEach(clients::add);
        Client client_ = new Client();
        String activity = "";
        for(Client client:clients){
            Long id_ = client.getIdUser().getId();
            if (Objects.equals(id_, id))client_=client;
        }
        boolean isEnable = client_.getIdUser().isEnabled();
        if (isEnable) activity = "активен";
        else activity = "заблокирован";
        return activity;

    }


    @Override
    public Client findById(Long id) {
        Set<Client> clients = new HashSet<>();
        clientRepository.findAll().forEach(clients::add);
        for (Client client:clients){
            Long id_ = client.getId();
            if (Objects.equals(id, id_)) return client;
        }
        return null;
    }


}
