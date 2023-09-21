package com.mauro.project.helpdesk.config;

import com.mauro.project.helpdesk.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Bean
    public boolean instanciaDB(){
        if (value.equals("create")){
            this.dbService.instanciaDB();
        }
        return false;
    }
    // toda vez que tiver com o perfil de teste ativo o método instanciaDB da classe DBService vai ser chamado e vai subir as
    //instâncias e salvar no banco de dados.

}
