package br.com.inteliset.findserv.service.client.impl;
import br.com.inteliset.findserv.domain.model.client.Client;
import br.com.inteliset.findserv.domain.model.professional.Professional;
import br.com.inteliset.findserv.domain.repository.ClientRepository;
import br.com.inteliset.findserv.exception.DomainException;
import br.com.inteliset.findserv.service.address.AddressService;
import br.com.inteliset.findserv.service.client.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final AddressService addressService;
    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository, AddressService addressService) {
        this.repository = repository;
        this.addressService = addressService;
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

    @Transactional
    @Override
    public Client update(UUID id, Client client) {

        var clientDb = getReferenceById(id);

        if (clientDb.getActive().equals(false)){
            throw new EntityNotFoundException();
        }
        if (client.getPhone() != null) {
            clientDb.setPhone(client.getPhone());
        }
        var addressUpDate = addressService.updateAddress(clientDb.getAddressId(), client.getAddressId());
        clientDb.setAddressId(addressUpDate);
        return save(clientDb);
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public Optional<Client> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    @Override
    public Client getReferenceByCpf(String cpf) {
        return repository.getReferenceByCpf(cpf);
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }


}
