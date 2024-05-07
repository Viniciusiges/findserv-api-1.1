package br.com.inteliset.findserv.domain.repository;

import br.com.inteliset.findserv.domain.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {



}
