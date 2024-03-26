package io.github.booknet.services;

import io.github.booknet.models.Livro;

import java.util.List;

public interface LivroService {

    public List<Livro> listarLivros();
    public Livro buscarLivroPorId(Long id);
    public Livro salvarLivro(Livro livro);
    public Livro atualizarLivro(Livro livro);
    public void deletarLivro(Long id);

}
