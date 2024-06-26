package br.com.inteliset.findserv.domain.repository;

import br.com.inteliset.findserv.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    UserDetails findByLogin(String login);

}
