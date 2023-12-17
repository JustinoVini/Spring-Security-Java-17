package br.com.vinicius.crud.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vinicius.crud.domain.models.User;

public interface UserRepository extends JpaRepository<User, String> {

}
