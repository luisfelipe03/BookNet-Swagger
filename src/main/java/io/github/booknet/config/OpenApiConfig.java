package io.github.booknet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;
import java.util.Arrays;

@Configuration // Indica que esta classe é uma classe de configuração do Spring
public class OpenApiConfig {

    // Configuração de informações básicas da API de gerenciamento de livros
    @Bean // Indica que este método produz um bean gerenciado pelo Spring
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gerenciamento de Livros Pessoais") // Título da API
                        .version("1.0") // Versão da API
                        .description("API para gerenciar livros pessoais") // Descrição da API
                        .contact(new Contact()
                                .name("Equipe de Desenvolvimento") // Nome do contato
                                .email("dev@example.com") // Email do contato
                                .url("https://www.example.com")) // URL do contato
                        .license(new License()
                                .name("Licença de Uso") // Nome da licença
                                .url("https://www.example.com/license")));// URL da licença
    }
}