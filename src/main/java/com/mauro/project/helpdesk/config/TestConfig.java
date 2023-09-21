package com.mauro.project.helpdesk.config;

import com.mauro.project.helpdesk.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public void instanciaDB(){
        this.dbService.instanciaDB();
    }
    // toda vez que tiver com o perfil de teste ativo o método instanciaDB da classe DBService vai ser chamado e vai subir as
    //instâncias e salvar no banco de dados.

}
