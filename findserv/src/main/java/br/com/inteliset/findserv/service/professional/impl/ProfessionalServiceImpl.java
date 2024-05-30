package br.com.inteliset.findserv.service.professional.impl;

import br.com.inteliset.findserv.domain.model.client.Client;
import br.com.inteliset.findserv.domain.model.professional.Professional;
import br.com.inteliset.findserv.domain.repository.ProfessionalRepository;
import br.com.inteliset.findserv.service.address.AddressService;
import br.com.inteliset.findserv.service.professional.ProfessionalService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    private final AddressService addressService;
    private final ProfessionalRepository repository;

    public ProfessionalServiceImpl(ProfessionalRepository repository, AddressService addressService) {
        this.repository = repository;
        this.addressService = addressService;
    }

    @Transactional
    @Override
    public Professional save(Professional professional) {
        return repository.save(professional);
    }

    @Override
    public Page<Professional> findAllByActiveTrue(Pageable page) {
        return repository.findAllByActiveTrue(page);
    }

    @Override
    public Professional getReferenceById(UUID id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Optional<Professional> findById(UUID id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    @Override
    public Professional update(UUID id, Professional professional) {

        var professionalDb = getReferenceById(id);

        if (professionalDb.getActive().equals(false) || professionalDb.getActive() == null){
            throw new EntityNotFoundException();
        }
        if (professional.getPhone() != null) {
            professionalDb.setPhone(professional.getPhone());
        }
        var addressUpDate = addressService.updateAddress(professionalDb.getAddressId(), professional.getAddressId());
        professionalDb.setAddressId(addressUpDate);
        return save(professionalDb);
    }

    @Override
    public Optional<Professional> findByCpf(String cpf) {
        return  repository.findByCpf(cpf);
    }

    @Override
    public Professional getReferenceByCpf(String cpf) {
        return repository.getReferenceByCpf(cpf);
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }


}
