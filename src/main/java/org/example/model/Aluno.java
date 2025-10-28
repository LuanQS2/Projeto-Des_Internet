package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "alunos")
@Data
public class Aluno {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private int idade;

    public Aluno() {}

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}
