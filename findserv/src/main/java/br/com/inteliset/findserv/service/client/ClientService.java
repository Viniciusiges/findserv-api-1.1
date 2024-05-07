package br.com.inteliset.findserv.service.client;

import br.com.inteliset.findserv.domain.model.client.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {

    Client save(Client client);

    Page<Client> findAllByActiveTrue (Pageable page);

    Client getReferenceById(UUID id);

    List<Client> findAll();
    Client update (UUID id,Client client);

    Optional<Client> findById(UUID id);

}

