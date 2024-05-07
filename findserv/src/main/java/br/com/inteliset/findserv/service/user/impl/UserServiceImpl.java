package br.com.inteliset.findserv.service.user.impl;

import br.com.inteliset.findserv.domain.repository.UserRepository;
import br.com.inteliset.findserv.service.user.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails findByLogin(String username) {
        return repository.findByLogin(username);
    }
}
