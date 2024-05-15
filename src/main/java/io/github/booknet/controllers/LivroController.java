package io.github.booknet.controllers;

import io.github.booknet.facade.Facade;
import io.github.booknet.models.Avaliacao;
import io.github.booknet.models.Livro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/livros")
@Tag(name = "Livros", description = "API para gerenciamento de livros")
public class LivroController {

    @Autowired
    private Facade facade;

    @GetMapping
    @Operation(summary = "Listar livros",
               description = "Lista todos os livros cadastrados",
               tags = {"Livros"},
               responses = {
                    @ApiResponse(responseCode = "200", description = "Livros listados com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")

               },
               parameters = {
                    @Parameter(name = "id", description = "ID do livro a ser recuperado", example = "1", in = ParameterIn.PATH, required = true)

               }
    )
    public List<Livro> listarLivros() {
        return facade.listarLivros();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar livro por ID",
               description = "Busca um livro pelo ID",
               tags = {"Livros"},
               responses = {
                    @ApiResponse(responseCode = "200", description = "Livro encontrado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Livro não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
               }
    )
    public Livro buscarLivroPorId(@PathVariable Long id) {
        return facade.buscarLivroPorId(id);
    }

    @PostMapping
    @Operation(summary = "Cadastrar livro",
               description = "Cadastra um novo livro",
               tags = {"Livros"},
               responses = {
                    @ApiResponse(responseCode = "200", description = "Livro cadastrado com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
               }
    )
    public Livro cadastrarLivro(@RequestBody Livro livro) {
        return facade.salvarLivro(livro);
    }

    @PatchMapping
    @Operation(summary = "Atualizar livro",
               description = "Atualiza um livro",
               tags = {"Livros"},
               responses = {
                    @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Livro não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
               },
               parameters = {
                       @Parameter(name = "livro", description = "Livro a ser atualizado", required = true)

               }
    )
    public Livro atualizarLivro(@RequestBody Livro livro) {
        return facade.atualizarLivro(livro);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar livro",
               description = "Deleta um livro",
               tags = {"Livros"},
               responses = {
                    @ApiResponse(responseCode = "200", description = "Livro deletado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Livro não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
               }
    )
    public void deletarLivro(@PathVariable Long id) {
        facade.deletarLivro(id);
    }

    @PostMapping("/{id}/avaliar")
    @Operation(summary = "Avaliar livro",
               description = "Avalia um livro",
               tags = {"Livros"},
               responses = {
                    @ApiResponse(responseCode = "200", description = "Livro avaliado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Livro não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
               }
    )
    public void avaliarLivro(@PathVariable Long id,@RequestBody Avaliacao avaliacao) {
        facade.avaliarLivro(id, avaliacao);
    }

    @PatchMapping("/{id}/avaliar")
    @Operation(summary = "Atualizar avaliação",
               description = "Atualiza a avaliação de um livro",
               tags = {"Livros"},
               responses = {
                    @ApiResponse(responseCode = "200", description = "Avaliação atualizada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Avaliação não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
               }
    )
    public void atualizarAvaliacao(@PathVariable Long id, @RequestBody Avaliacao avaliacao) {
        facade.atualizarAvaliacao(id, avaliacao);
    }

    @DeleteMapping("/{id}/avaliar")
    @Operation(summary = "Deletar avaliação",
               description = "Deleta a avaliação de um livro",
               tags = {"Livros"},
               responses = {
                    @ApiResponse(responseCode = "200", description = "Avaliação deletada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Avaliação não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
               }
    )
    public void deletarAvaliacao(@PathVariable Long id) {
        facade.deletarAvaliacao(id);
    }
}