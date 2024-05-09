package br.com.inteliset.findserv.service.address.impl;

import br.com.inteliset.findserv.domain.model.address.Address;
import br.com.inteliset.findserv.domain.model.client.Client;
import br.com.inteliset.findserv.domain.repository.AddressRepository;
import br.com.inteliset.findserv.domain.repository.ClientRepository;
import br.com.inteliset.findserv.exception.DomainException;
import br.com.inteliset.findserv.service.address.AddressService;
import br.com.inteliset.findserv.service.client.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public Address save(Client client, Address address) {

    address.setClient(client);
        return repository.save(address);
    }

    @Override
    public Address getReferenceById(UUID id) {
        return repository.getReferenceById(id);
    }

}