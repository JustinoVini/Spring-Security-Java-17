package br.com.vinicius.crud.domain.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduct(

                String id,

                @NotBlank String name,

                @NotNull double price_in_cents

) {

}
