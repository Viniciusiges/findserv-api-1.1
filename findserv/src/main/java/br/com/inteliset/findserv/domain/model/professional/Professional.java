package br.com.inteliset.findserv.domain.model.professional;

import br.com.inteliset.findserv.domain.model.address.Address;
import br.com.inteliset.findserv.dto.professionalModel.ProfessionalRegistrationData;
import br.com.inteliset.findserv.dto.professionalModel.ProfessionalUpdateData;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Table(name = "professional")
@Entity(name = "Professional")
public class Professional {



    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    @Column(name = "been_working")
    private String beenWorking;
    @Column(name = "value_hour")
    private String valueHour;
    @Enumerated(EnumType.STRING)
    private Activity activity;
    //Embuti uma nova tabela dentro dessa entidade

    @OneToOne
    private Address addressId;

    private Boolean active;

    public Professional() {}


//    public Professional(ProfessionalRegistrationData date) {
//        this.name = date.name();
//        this.cpf = date.cpf();
//        this.phone = date.phone();
//        this.email = date.email();
//        this.beenWorking = date.beenWorking();
//        this.valueHour = date.valueHour();
//        this.activity = date.activity();
//        this.address = new Address(date.address());
//        this.active = true;
//    }

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

    public String getBeenWorking() {
        return beenWorking;
    }

    public void setBeenWorking(String beenWorking) {
        this.beenWorking = beenWorking;
    }

    public String getValueHour() {
        return valueHour;
    }

    public void setValueHour(String valueHour) {
        this.valueHour = valueHour;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Address getAddress() {
        return addressId;
    }

    public void setAddress(Address addressId) {
        this.addressId = addressId;
    }
//Aqui estamos criando um hash code unico somente para o ID , e mudando a forma de comparar com equals.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professional that = (Professional) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

//    public void updateInformation(ProfessionalUpdateData dates) {
//        if (dates.phone() != null){
//            this.phone = dates.phone();
//        }
//        if (dates.datesAddress() != null){
//            this.address.updateInformation(dates.datesAddress());
//        }
//        if (dates.activity() != null){
//            this.activity = dates.activity();
//        }
//        if (dates.valueHour() != null){
//            this.valueHour = dates.valueHour();
//        }
//    }

    public void delete() {
        this.active = false;
    }

    public void active() {
        this.active = true;
    }
}
