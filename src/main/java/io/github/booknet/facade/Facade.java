package io.github.booknet.facade;

import io.github.booknet.models.Avaliacao;
import io.github.booknet.models.Livro;
import io.github.booknet.services.AvaliacaoService;
import io.github.booknet.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {

    @Autowired
    private LivroService livroService;
    @Autowired
    private AvaliacaoService avaliacaoService;

    //Livro--------------------------------------------------------
    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }

    public Livro buscarLivroPorId(Long id) {
        return livroService.buscarLivroPorId(id);
    }

    public Livro salvarLivro(Livro livro) {
        return livroService.salvarLivro(livro);
    }

    public Livro atualizarLivro(Livro livro) {
        return livroService.atualizarLivro(livro);
    }
    public void deletarLivro(Long id) {
        livroService.deletarLivro(id);
    }

    //Avaliacao--------------------------------------------------------
    public void avaliarLivro(Long idLivro, Avaliacao avaliacao) {
        avaliacaoService.avaliarLivro(idLivro, avaliacao);
    }
    public void atualizarAvaliacao(Long idLivro, Avaliacao avaliacao) {
        avaliacaoService.atualizarAvaliacao(idLivro, avaliacao);
    }

    public void deletarAvaliacao(Long idLivro) {
        avaliacaoService.deletarAvaliacao(idLivro);
    }

}
