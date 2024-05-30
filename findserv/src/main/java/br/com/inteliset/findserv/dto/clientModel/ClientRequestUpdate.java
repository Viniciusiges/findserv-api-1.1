package br.com.inteliset.findserv.dto.clientModel;

import br.com.inteliset.findserv.dto.addressModel.AddressRequestUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.NumberFormat;

public class ClientRequestUpdate {


    @Positive
    @Pattern(regexp = "\\d{11}", message = "Numero de telefone não corresponde a um numero valido")
    private String phone;

    @Valid
    private AddressRequestUpdate address;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AddressRequestUpdate getAddress() {
        return address;
    }

    public void setAddress(AddressRequestUpdate address) {
        this.address = address;
    }
}
