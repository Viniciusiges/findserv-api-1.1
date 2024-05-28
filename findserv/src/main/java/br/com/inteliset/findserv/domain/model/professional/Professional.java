package br.com.inteliset.findserv.domain.model.professional;

import br.com.inteliset.findserv.domain.model.address.Address;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Table(name = "professional")
@Entity
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

    @OneToOne(mappedBy = "professional")
    private Address addressId;

    private Boolean active;

    public Professional() {}

    public Professional(UUID id, String name, String cpf, String phone, String email, String beenWorking, String valueHour, Activity activity, Address addressId, Boolean active) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.email = email;
        this.beenWorking = beenWorking;
        this.valueHour = valueHour;
        this.activity = activity;
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
