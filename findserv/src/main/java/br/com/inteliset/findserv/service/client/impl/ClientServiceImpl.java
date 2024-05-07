package br.com.inteliset.findserv.service.client.impl;
import br.com.inteliset.findserv.domain.model.client.Client;
import br.com.inteliset.findserv.domain.repository.AddressRepository;
import br.com.inteliset.findserv.domain.repository.ClientRepository;
import br.com.inteliset.findserv.exception.DomainException;
import br.com.inteliset.findserv.service.address.AddressService;
import br.com.inteliset.findserv.service.client.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }
    @Transactional
    @Override
    public Client save(Client client) {
        return repository.save(client);
    }

    @Override
    public Page<Client> findAllByActiveTrue(Pageable page) {
        return repository.findAllByActiveTrue(page);
    }

    @Override
    public Client getReferenceById(UUID id) {
        return repository.getReferenceById(id);
    }


    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }


//    @Override
//    public Client update(UUID id, Client client) {
//        Optional<Client> optClient = this.findById(id);
//
//        if (optClient.isEmpty()) {
//            throw new DomainException("Cliente nao encontrado");
//        }
//
//        return save(client);
//    }

    @Transactional
    @Override
    public Client update(UUID id, Client client) {

        var clientDb = getReferenceById(id);

        if (clientDb.getActive().equals(false)){
            throw new DomainException("Usuario não encontrado");
        }
        if (client.getPhone() != null) {
            clientDb.setPhone(client.getPhone());
        }
        if (client.getAddressId().getPostalCode() != null) {
            clientDb.getAddressId().setPostalCode(client.getAddressId().getPostalCode());
        }
        if (client.getAddressId().getState() != null) {
            clientDb.getAddressId().setState(client.getAddressId().getState());
        }
        if (client.getAddressId().getCity() != null) {
            clientDb.getAddressId().setCity(client.getAddressId().getCity());
        }
        if (client.getAddressId().getDistrict() != null) {
            clientDb.getAddressId().setDistrict(client.getAddressId().getDistrict());
        }
        if (client.getAddressId().getStreet() != null) {
            clientDb.getAddressId().setStreet(client.getAddressId().getStreet());
        }
        if (client.getAddressId().getNumber() != null) {
            clientDb.getAddressId().setNumber(client.getAddressId().getNumber());
        }
        if (client.getAddressId().getComplement() != null) {
            clientDb.getAddressId().setComplement(client.getAddressId().getComplement());
        }
        return save(clientDb);
    }



    @Override
    public Optional<Client> findById(UUID id) {
        return repository.findById(id);
    }





//    @Override
//    public Client update(UUID id, Client client) {
//
//
//        Optional<Client> optClient = client.;
//        if (optClient.isEmpty()) {
//            throw new DomainException("Usuario não encontrado");
//        }
//
//       (client.setPhone(client.getPhone())) ;
//        return save()
//
//    }


}
