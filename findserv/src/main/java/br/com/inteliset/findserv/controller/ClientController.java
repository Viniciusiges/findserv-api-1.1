package br.com.inteliset.findserv.controller;

import br.com.inteliset.findserv.domain.model.client.Client;
import br.com.inteliset.findserv.dto.clientModel.*;
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
import org.springframework.web.util.UriComponentsBuilder;

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
        System.out.println("Estou aqui---------"+clientRequest.getAddress());
        var client2 = clientMapper.toEntity(clientRequest);
        var client = clientService.save(client2);
        var address = addressMapper.toEntity(clientRequest.getAddress());
        addressService.save(client, address);
        var clientSave = clientService.getReferenceById(client2.getId());
        System.out.println("------------");

        return ResponseEntity.status(HttpStatus.CREATED).body(clientMapper.toModel(clientSave));
    }

//    var clientResponse = clientMapper.toModel(clientService.getReferenceById(client.getId()));
//        System.out.println("------------"+clientResponse);
//

//    @PostMapping
//    @Transactional
//    public ResponseEntity<ClientResponse> toRegister(@RequestBody @Valid ClientRequest clientRequest, UriComponentsBuilder uriBuilder) {
//
//        var client = clientService.save(clientMapper.toEntity(clientRequest));
//        var address = addressMapper.toEntity(clientRequest.getAddress());
//        addressService.save(client, address);
//        var clientSave = clientService.getReferenceById(client.getId());
//
//        var uri = uriBuilder.path("/client").buildAndExpand(client.getId()).toUri();
//        return ResponseEntity.created(uri).body(clientMapper.toModel(clientSave));
//    }

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

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity toDelete(@PathVariable UUID id){
        var client= clientService.getReferenceById(id);
        client.delete();

        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity toDetail(@PathVariable UUID id){
//        var client = clientService.getReferenceById(id);
//        return ResponseEntity.ok(new ClientDetailedData(client));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDetail> toDetail(@PathVariable UUID id) {
        return clientService.findById(id)
                .map(clientMapper::toModelDetail)
                .map(clientResponseDetail -> ResponseEntity.status(HttpStatus.OK).body(clientResponseDetail))
                .orElse(ResponseEntity.notFound().build());
    }



//    @PatchMapping
//    @Transactional
//    public ResponseEntity reactivate(@RequestBody @Valid ClientActive data) {
//        var client = clientService.getReferenceById(data.id());
//        client.active();
//        return ResponseEntity.ok(new ClientDetailedData(client));
//    }

}
