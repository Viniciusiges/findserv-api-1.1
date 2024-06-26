package br.com.inteliset.findserv.controller;

import br.com.inteliset.findserv.dto.clientModel.ClientActive;
import br.com.inteliset.findserv.dto.clientModel.ClientRequestUpdate;
import br.com.inteliset.findserv.dto.clientModel.ClientResponse;
import br.com.inteliset.findserv.dto.professionalModel.*;
import br.com.inteliset.findserv.mapper.address.AddressMapper;
import br.com.inteliset.findserv.mapper.professional.ProfessionalMapper;
import br.com.inteliset.findserv.service.address.AddressService;
import br.com.inteliset.findserv.service.professional.ProfessionalService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/professional")
public class ProfessionalController {

    private final ProfessionalService professionalService;
    private final AddressMapper addressMapper;
    private final AddressService addressService;

    private final ProfessionalMapper professionalMapper;

    public ProfessionalController(ProfessionalService professionalService, ProfessionalMapper professionalMapper, AddressService addressService, AddressMapper addressMapper) {
        this.professionalService = professionalService;
        this.professionalMapper = professionalMapper;
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProfessionalResponse> toRegister(@RequestBody @Valid ProfessionalRequest professionalRequest) {

        var professional = professionalService.save(professionalMapper.toEntity(professionalRequest));
        var address = addressMapper.toEntity(professionalRequest.getAddress());
        addressService.save(professional, address);
        ProfessionalResponse professionalResponse = professionalMapper.toModel(professionalService.getReferenceById(professional.getId()));
        professionalResponse.setAddress(addressMapper.toModel(address));
        return ResponseEntity.status(HttpStatus.CREATED).body(professionalResponse);
    }

    @GetMapping
    public ResponseEntity <List<ProfessionalResponse>> toSearch(@PageableDefault(size = 9, sort = {"name"}) Pageable pages){
        var data = professionalMapper.toCollectionModel(professionalService.findAllByActiveTrue(pages));
        System.out.println(data);
        return ResponseEntity.ok(data);
    }

//    @PutMapping
//    @Transactional
//    public ResponseEntity toUpdate(@RequestBody @Valid ProfessionalUpdateData data){
//        var professional = professionalService.getReferenceById(data.id());
//        professional.updateInformation(data);
//        return ResponseEntity.ok(new ProfessionalDetailedData(professional));
//    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalResponse> toUpdate(@PathVariable UUID id, @RequestBody @Valid ProfessionalRequestUpdate request) {
        var professional = professionalMapper.toEntityUpdate(request);
        var clientResponse = professionalMapper.toModel(professionalService.update(id, professional));
        return ResponseEntity.status(HttpStatus.OK).body(clientResponse);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity toDelete(@PathVariable UUID id){
        professionalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/cpf/{cpf}")
    @Transactional
    public ResponseEntity toDisable(@PathVariable String cpf){
        var professional = professionalService.getReferenceByCpf(cpf);
        professional.delete();

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalDetail> toDetail(@PathVariable UUID id) {
        return professionalService.findById(id)
                .map(professionalMapper::toModelDetail)
                .map(professionalDetail -> ResponseEntity.status(HttpStatus.OK).body(professionalDetail))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ProfessionalDetail> toDetailCpf(@PathVariable String cpf) {
        return professionalService.findByCpf(cpf)
                .map(professionalMapper::toModelDetail)
                .map(professionalDetail -> ResponseEntity.status(HttpStatus.OK).body(professionalDetail))
                .orElse(ResponseEntity.notFound().build());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity toDetail(@PathVariable UUID id){
//        var professional = professionalService.getReferenceById(id);
//        return ResponseEntity.ok(new ProfessionalDetailedData(professional));
//    }

    @PatchMapping
    @Transactional
    public ResponseEntity<ProfessionalResponse> reactivate(@RequestBody @Valid ProfessionalActive professionalActive) {
        var professional = professionalService.getReferenceById(professionalActive.getId());
        professional.active();

        return ResponseEntity.ok(professionalMapper.toModel(professional));
    }

}