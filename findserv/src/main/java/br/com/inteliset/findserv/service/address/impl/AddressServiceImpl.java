package br.com.inteliset.findserv.service.address.impl;

import br.com.inteliset.findserv.domain.model.address.Address;
import br.com.inteliset.findserv.domain.model.client.Client;
import br.com.inteliset.findserv.domain.model.professional.Professional;
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

    @Transactional
    @Override
    public Address save(Professional professional, Address address) {
    address.setProfessional(professional);
        return repository.save(address);
    }

    @Override
    public Address getReferenceById(UUID id) {
        return repository.getReferenceById(id);
    }

    public Address updateAddress(Address addressDb, Address addressUpDate) {

        if (addressUpDate.getPostalCode() != null) {
            addressDb.setPostalCode(addressUpDate.getPostalCode());
        }
        if (addressUpDate.getState() != null) {
            addressDb.setState(addressUpDate.getState());
        }
        if (addressUpDate.getCity() != null) {
            addressDb.setCity(addressUpDate.getCity());
        }
        if (addressUpDate.getDistrict() != null) {
            addressDb.setDistrict(addressUpDate.getDistrict());
        }
        if (addressUpDate.getStreet() != null) {
            addressDb.setStreet(addressUpDate.getStreet());
        }
        if (addressUpDate.getNumber() != null) {
            addressDb.setNumber(addressUpDate.getNumber());
        }
        if (addressUpDate.getComplement() != null) {
            addressDb.setComplement(addressUpDate.getComplement());
        }

        return addressDb;
    }

}