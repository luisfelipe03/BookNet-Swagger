package io.github.booknet.services;

import io.github.booknet.excepions.ResourceNotFoundException;
import io.github.booknet.models.Livro;
import io.github.booknet.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository repository;
    @Override
    public List<Livro> listarLivros() {
        return repository.findAll();
    }

    @Override
    public Livro buscarLivroPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Não existe livro cadastrado com id: " + id));
    }

    @Override
    public Livro salvarLivro(Livro livro) {
        return repository.save(livro);
    }

    @Override
    public Livro atualizarLivro(Livro livro) {
        var entity = repository.findById(livro.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Não existe livro cadastrado com id:" + livro.getId()));

        entity.setTitulo(livro.getTitulo());
        entity.setAutor(livro.getAutor());
        entity.setAno(livro.getAno());
        entity.setGenero(livro.getGenero());
        entity.setEditora(livro.getEditora());
        entity.setIdioma(livro.getIdioma());
        entity.setPreco(livro.getPreco());
        entity.setPaginas(livro.getPaginas());
        entity.setInicioLeitura(livro.getInicioLeitura());
        entity.setFimLeitura(livro.getFimLeitura());

        return repository.save(livro);
    }

    @Override
    public void deletarLivro(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe livro cadastrado com id: " + id));

        // Exclui a entidade do repositório
        repository.delete(entity);
    }
}
