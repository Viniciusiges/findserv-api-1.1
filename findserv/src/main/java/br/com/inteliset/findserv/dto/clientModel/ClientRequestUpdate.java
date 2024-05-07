package br.com.inteliset.findserv.dto.clientModel;

import br.com.inteliset.findserv.dto.addressModel.AddressRequestUpdate;

public class ClientRequestUpdate {

    private String phone;
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
