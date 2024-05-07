package br.com.inteliset.findserv.domain.model.client;

import br.com.inteliset.findserv.domain.model.address.Address;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;


@Table(name = "client")
@Entity(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    @OneToOne(mappedBy = "client")
    private Address addressId;
    private Boolean active;

    public Client () {}

    public Client(UUID id, String name, String cpf, String phone, String email, Address addressId, Boolean active) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.email = email;
        this.addressId = addressId;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client that = (Client) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void delete() {
        this.active = false;
    }

    public void active() {
        this.active = true;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", addressId=" + addressId +
                ", active=" + active +
                '}';
    }
}

