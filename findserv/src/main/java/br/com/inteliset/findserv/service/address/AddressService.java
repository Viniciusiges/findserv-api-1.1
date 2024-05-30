package br.com.inteliset.findserv.service.address;

import br.com.inteliset.findserv.domain.model.address.Address;
import br.com.inteliset.findserv.domain.model.client.Client;
import br.com.inteliset.findserv.domain.model.professional.Professional;

import java.util.UUID;

public interface AddressService {

    Address save( Client client, Address address);

    Address save(Professional professional, Address address);
    Address updateAddress(Address addressDb, Address addressUpDate);

}
