package br.com.vinicius.crud.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.vinicius.crud.domain.models.User;

public interface UserRepository extends JpaRepository<User, String> {

    UserDetails findByLogin(String login);

}
