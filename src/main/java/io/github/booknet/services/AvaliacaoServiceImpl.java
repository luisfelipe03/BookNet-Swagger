package io.github.booknet.services;

import io.github.booknet.models.Avaliacao;
import io.github.booknet.models.Livro;
import io.github.booknet.repositories.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;
    @Autowired
    private LivroService livroService;

    @Override
    public void avaliarLivro(Long idLivro, Avaliacao avaliacao) {
        var a = repository.save(avaliacao);
        Livro livro = livroService.buscarLivroPorId(idLivro);
        if (livro != null) {
            livro.setAvaliacao(a);
            livroService.atualizarLivro(livro);
        }
    }

    @Override
    public void deletarAvaliacao(Long idLivro) {
        Livro livro = livroService.buscarLivroPorId(idLivro);
        if (livro != null) {
            var avaliacao = livro.getAvaliacao();
            livro.setAvaliacao(null);
            repository.delete(avaliacao);
            livroService.atualizarLivro(livro);
        }
    }

    @Override
    public void atualizarAvaliacao(Long idLivro, Avaliacao avaliacao) {
        var a = repository.save(avaliacao);
        Livro livro = livroService.buscarLivroPorId(idLivro);
        if (livro != null) {
            livro.getAvaliacao().setNota(a.getNota());
            livro.getAvaliacao().setResenha(a.getResenha());
            livroService.atualizarLivro(livro);
        }
    }
}
