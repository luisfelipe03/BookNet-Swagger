package io.github.booknet.services;

import io.github.booknet.models.Avaliacao;

public interface AvaliacaoService {

    public void avaliarLivro(Long idLivro, Avaliacao avaliacao);
    public void deletarAvaliacao(Long idLivro);
    public void atualizarAvaliacao(Long idLivro, Avaliacao avaliacao);
}
