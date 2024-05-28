package br.com.inteliset.findserv.domain.model.address;

import br.com.inteliset.findserv.domain.model.client.Client;
import br.com.inteliset.findserv.domain.model.professional.Professional;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.util.UUID;
@Table(name = "address")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "postal_code")
    private String postalCode;
    private String state;
    private String city;
    private String district;
    private String street;
    @Positive
    private String number;
    private String complement;
    @JoinColumn(name = "professional_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Professional professional;

    @JoinColumn(name = "client_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Client client;


    public Address() {
        
    }

    public Address(UUID id, String postalCode, String state, String city, String district, String street, String number, String complement, Client client, Professional professional) {
        this.id = id;
        this.postalCode = postalCode;
        this.state = state;
        this.city = city;
        this.district = district;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.professional = professional;
        this.client = client;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", postalCode='" + postalCode + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", complement='" + complement + '\'' +
//                ", professionalId=" + professional + '\'' +
                ", clientId=" + client +'\'' +
                '}';
    }

}
