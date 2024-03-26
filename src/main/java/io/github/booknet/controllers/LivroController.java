package io.github.booknet.controllers;

import io.github.booknet.facade.Facade;
import io.github.booknet.models.Avaliacao;
import io.github.booknet.models.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/livros")
public class LivroController {

    @Autowired
    private Facade facade;

    @GetMapping
    public List<Livro> listarLivros() {
        return facade.listarLivros();
    }

    @GetMapping("/{id}")
    public Livro buscarLivroPorId(@PathVariable Long id) {
        return facade.buscarLivroPorId(id);
    }

    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro) {
        return facade.salvarLivro(livro);
    }

    @PatchMapping
    public Livro atualizarLivro(@RequestBody Livro livro) {
        return facade.atualizarLivro(livro);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        facade.deletarLivro(id);
    }

    @PostMapping("/{id}/avaliar")
    public void avaliarLivro(@PathVariable Long id,@RequestBody Avaliacao avaliacao) {
        facade.avaliarLivro(id, avaliacao);
    }

    @PatchMapping("/{id}/avaliar")
    public void atualizarAvaliacao(@PathVariable Long id, @RequestBody Avaliacao avaliacao) {
        facade.atualizarAvaliacao(id, avaliacao);
    }

    @DeleteMapping("/{id}/avaliar")
    public void deletarAvaliacao(@PathVariable Long id) {
        facade.deletarAvaliacao(id);
    }
}