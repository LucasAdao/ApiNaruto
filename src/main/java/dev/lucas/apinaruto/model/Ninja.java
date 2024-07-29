package dev.lucas.apinaruto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ninja")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ninja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String nome;
    String aldeia;
    int idade;
    String elemento;
    String imgUrl;

}
