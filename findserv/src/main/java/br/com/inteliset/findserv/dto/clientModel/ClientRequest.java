package br.com.inteliset.findserv.dto.clientModel;

import br.com.inteliset.findserv.dto.addressModel.AddressRequest;
import jakarta.validation.constraints.*;

public class ClientRequest {

    @NotBlank
    private String name;

    @Positive
    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String cpf;

    @Positive
    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String phone;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private AddressRequest address;//com o nome do atributo como addressRequest, nao funcionou
    private Boolean active = true;

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public AddressRequest getAddress() {
        return address;
    }

    public void setAddress(AddressRequest address) {
        this.address = address;
    }


}
