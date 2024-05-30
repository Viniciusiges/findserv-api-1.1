package br.com.inteliset.findserv.controller;

import br.com.inteliset.findserv.dto.clientModel.*;
import br.com.inteliset.findserv.dto.professionalModel.ProfessionalDetail;
import br.com.inteliset.findserv.mapper.address.AddressMapper;
import br.com.inteliset.findserv.mapper.client.ClientMapper;
import br.com.inteliset.findserv.service.address.AddressService;
import br.com.inteliset.findserv.service.client.ClientService;
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
@RequestMapping("/client")
public class ClientController {


    private final ClientMapper clientMapper;
    private final ClientService clientService;
    private final AddressMapper addressMapper;
    private final AddressService addressService;


    public ClientController(ClientService clientService, ClientMapper clientMapper, AddressService addressService, AddressMapper addressMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClientResponse> toRegister(@RequestBody @Valid ClientRequest clientRequest) {

        var client = clientService.save(clientMapper.toEntity(clientRequest));
        var address = addressMapper.toEntity(clientRequest.getAddress());
        addressService.save(client, address);
        ClientResponse clientResponse = clientMapper.toModel(clientService.getReferenceById(client.getId()));
        clientResponse.setAddress(addressMapper.toModel(address));
        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponse);
    }

    @GetMapping
    public ResponseEntity <List<ClientResponse>> toSearch(@PageableDefault(size = 9, sort = {"name"}) Pageable pages){
        var data = clientMapper.toCollectionModel(clientService.findAllByActiveTrue(pages));
        return ResponseEntity.ok(data);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> toUpdate(@PathVariable UUID id, @RequestBody @Valid ClientRequestUpdate request) {
        var client = clientMapper.toEntityUpdate(request);
        var clientResponse = clientMapper.toModel(clientService.update(id, client));
        return ResponseEntity.status(HttpStatus.OK).body(clientResponse);
    }
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity toDelete(@PathVariable UUID id){
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cpf/{cpf}")
    @Transactional
    public ResponseEntity toDisable(@PathVariable String cpf){
        var client= clientService.getReferenceByCpf(cpf);
        client.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDetail> toDetail(@PathVariable UUID id) {
        return clientService.findById(id)
                .map(clientMapper::toModelDetail)
                .map(clientDetail -> ResponseEntity.status(HttpStatus.OK).body(clientDetail))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ClientDetail> toDetailCpf(@PathVariable String cpf) {
        return clientService.findByCpf(cpf)
                .map(clientMapper::toModelDetail)
                .map(clientDetail -> ResponseEntity.status(HttpStatus.OK).body(clientDetail))
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping
    @Transactional
    public ResponseEntity<ClientResponse> reactivate(@RequestBody @Valid ClientActive clientActive) {
        var client = clientService.getReferenceById(clientActive.getId());
        client.active();

        return ResponseEntity.ok(clientMapper.toModel(client));
    }

}
