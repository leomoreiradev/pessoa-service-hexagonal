package com.leomoreiradev.pessoaservicehexagonal.config;

import com.leomoreiradev.pessoaservicehexagonal.datasources.port.PesssoaRepositoryPort;
import com.leomoreiradev.pessoaservicehexagonal.interactors.PessoaUseCase;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.PessoaMapper;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.PessoaMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PessoaUseCase pessoaUseCase (PesssoaRepositoryPort pesssoaRepositoryPort) {
        return new PessoaUseCase(pesssoaRepositoryPort);
    }

    @Bean
    public PessoaMapper pessoaMapper() {
        return new PessoaMapperImpl();
    }
}
