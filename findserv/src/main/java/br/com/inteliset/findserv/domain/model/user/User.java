package br.com.inteliset.findserv.domain.model.user;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Table(name = "users")
@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String login;
    private String password;



    public UUID getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
