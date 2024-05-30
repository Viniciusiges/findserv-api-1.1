package br.com.inteliset.findserv.domain.repository;

import br.com.inteliset.findserv.domain.model.professional.Professional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfessionalRepository extends JpaRepository<Professional, UUID> {
    Page<Professional> findAllByActiveTrue(Pageable pages);
    Optional<Professional> findByCpf (String cpf);

    Professional getReferenceByCpf (String cpf);

}
