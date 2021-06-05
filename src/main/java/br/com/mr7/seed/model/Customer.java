package br.com.mr7.seed.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
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
    private String name;

    @Column(nullable = false,length = 11)
    private String document;

    @Column(name= "data_register")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateRegister;

    @PrePersist
    public void prePersist(){
        setDateRegister(LocalDate.now());
    }


}
