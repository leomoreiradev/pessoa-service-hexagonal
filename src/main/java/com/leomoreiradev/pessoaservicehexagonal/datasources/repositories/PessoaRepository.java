package com.leomoreiradev.pessoaservicehexagonal.datasources.repositories;

import com.leomoreiradev.pessoaservicehexagonal.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
