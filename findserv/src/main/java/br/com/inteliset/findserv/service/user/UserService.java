package br.com.inteliset.findserv.service.user;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails findByLogin(String login);
}
