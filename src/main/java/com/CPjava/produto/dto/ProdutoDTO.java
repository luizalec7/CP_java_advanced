package com.CPjava.produto.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProdutoDTO {

    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @DecimalMin(value = "0.01")
    private BigDecimal preco;

    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}")
    private String telefone;

    @PastOrPresent
    private LocalDate dataCadastro;
}
