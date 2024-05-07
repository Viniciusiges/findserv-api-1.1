package br.com.inteliset.findserv.service.professional;

import br.com.inteliset.findserv.domain.model.professional.Professional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProfessionalService {
    Professional save(Professional professional);

    Page<Professional> findAllByActiveTrue (Pageable page);

    Professional getReferenceById(UUID id);


}
