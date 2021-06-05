package br.com.mr7.seed.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
/***
 * @Getter@Setter
 * Cria os getters e setters
 * gera toString equals e o constructor default e
 *  com parametros
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String name;

    @Column(nullable = false,length = 11)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String document;

    @Column(name= "data_register",updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateRegister;

    @PrePersist
    public void prePersist(){
        setDateRegister(LocalDate.now());
    }


}
