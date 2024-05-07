package br.com.inteliset.findserv.service.professional.impl;

import br.com.inteliset.findserv.domain.model.professional.Professional;
import br.com.inteliset.findserv.domain.repository.ProfessionalRepository;
import br.com.inteliset.findserv.service.professional.ProfessionalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    private final ProfessionalRepository repository;

    public ProfessionalServiceImpl(ProfessionalRepository repository) {
        this.repository = repository;
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



}
