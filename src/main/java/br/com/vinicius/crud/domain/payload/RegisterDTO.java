package br.com.vinicius.crud.domain.payload;

import br.com.vinicius.crud.domain.models.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
