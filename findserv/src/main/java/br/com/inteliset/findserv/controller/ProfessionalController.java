package br.com.inteliset.findserv.controller;

import br.com.inteliset.findserv.dto.clientModel.ClientResponseDetail;
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
    public ResponseEntity<ProfessionalDetail> toDetail(@PathVariable UUID id) {
        return professionalService.findById(id)
                .map(professionalMapper::toModelDetail)
                .map(professionalDetail -> ResponseEntity.status(HttpStatus.OK).body(professionalDetail))
                .orElse(ResponseEntity.notFound().build());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity toDetail(@PathVariable UUID id){
//        var professional = professionalService.getReferenceById(id);
//        return ResponseEntity.ok(new ProfessionalDetailedData(professional));
//    }

//    @PatchMapping
//    @Transactional
//    public ResponseEntity reactivate(@RequestBody @Valid ProfessionalActive data) {
//        var professional = professionalService.getReferenceById(data.id());
//        professional.active();
//        return ResponseEntity.ok(new ProfessionalDetailedData(professional));
//    }

}