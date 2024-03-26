package io.github.booknet.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int nota;
    private String resenha;

    public Avaliacao() {
    }

    public Avaliacao(int nota, String resenha) {
        this.nota = nota;
        this.resenha = resenha;
    }

    public long getId() {
        return id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Avaliacao avaliacao)) return false;
        return id == avaliacao.id && nota == avaliacao.nota && Objects.equals(resenha, avaliacao.resenha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nota, resenha);
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "id=" + id +
                ", nota=" + nota +
                ", resenha='" + resenha + '\'' +
                '}';
    }
}
