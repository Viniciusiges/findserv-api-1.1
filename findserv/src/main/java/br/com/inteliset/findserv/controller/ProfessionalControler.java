package br.com.inteliset.findserv.controller;

import br.com.inteliset.findserv.domain.model.professional.Professional;
import br.com.inteliset.findserv.dto.clientModel.ClientRequest;
import br.com.inteliset.findserv.dto.clientModel.ClientResponse;
import br.com.inteliset.findserv.dto.professionalModel.*;
import br.com.inteliset.findserv.mapper.professional.ProfessionalMapper;
import br.com.inteliset.findserv.service.professional.ProfessionalService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/professional")
public class ProfessionalControler {

    private final ProfessionalService professionalService;

    private final ProfessionalMapper professionalMapper;

    public ProfessionalControler(ProfessionalService professionalService, ProfessionalMapper professionalMapper) {
        this.professionalService = professionalService;
        this.professionalMapper = professionalMapper;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProfessionalResponse> toRegister(@RequestBody @Valid ProfessionalRequest data, UriComponentsBuilder uriBuilder) {
        var professional = professionalService.save(professionalMapper.toEntity(data));
        var uri = uriBuilder.path("/client/{id}").buildAndExpand(professional.getId()).toUri();
        return ResponseEntity.created(uri).body(professionalMapper.toModel(professional));
    }

    @GetMapping
    public ResponseEntity <List<ProfessionalResponse>> toSearch(@PageableDefault(size = 9, sort = {"name"}) Pageable pages){
        var data = professionalMapper.toCollectionModel(professionalService.findAllByActiveTrue(pages));
        return ResponseEntity.ok(data);
    }



//    @PutMapping
//    @Transactional
//    public ResponseEntity toUpdate(@RequestBody @Valid ProfessionalUpdateData data){
//        var professional = professionalService.getReferenceById(data.id());
//        professional.updateInformation(data);
//        return ResponseEntity.ok(new ProfessionalDetailedData(professional));
//    }

//    @Transactional
//    @DeleteMapping("/{id}")
//    public void toDelete(@PathVariable UUID id){
//        repository.deleteById(id);
//    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity toDelete(@PathVariable UUID id){
        var professional = professionalService.getReferenceById(id);
        professional.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity toDetail(@PathVariable UUID id){
        var professional = professionalService.getReferenceById(id);
        return ResponseEntity.ok(new ProfessionalDetailedData(professional));
    }

    @PatchMapping
    @Transactional
    public ResponseEntity reactivate(@RequestBody @Valid ProfessionalActive data) {
        var professional = professionalService.getReferenceById(data.id());
        professional.active();
        return ResponseEntity.ok(new ProfessionalDetailedData(professional));
    }

}