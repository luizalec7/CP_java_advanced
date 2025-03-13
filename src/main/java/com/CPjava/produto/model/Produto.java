package com.CPjava.produto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;

    @NotBlank(message = "A descrição não pode estar em branco")
    private String descricao;

    @DecimalMin(value = "0.01", message = "O preço deve ser maior que 0")
    private BigDecimal preco;

    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}", message = "O telefone deve seguir o formato (XX) XXXX-XXXX ou (XX) XXXXX-XXXX")
    private String telefone;

    @PastOrPresent(message = "A data de cadastro deve ser no passado ou presente")
    private LocalDate dataCadastro;
}