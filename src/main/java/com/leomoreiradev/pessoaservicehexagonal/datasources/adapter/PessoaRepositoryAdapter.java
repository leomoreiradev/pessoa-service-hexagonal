package com.leomoreiradev.pessoaservicehexagonal.datasources.adapter;

import com.leomoreiradev.pessoaservicehexagonal.datasources.port.PesssoaRepositoryPort;
import com.leomoreiradev.pessoaservicehexagonal.datasources.repositories.PessoaRepository;
import com.leomoreiradev.pessoaservicehexagonal.entities.Pessoa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PessoaRepositoryAdapter implements PesssoaRepositoryPort {

    private final PessoaRepository pessoaRepository;

    public PessoaRepositoryAdapter(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa buscarPessoaPeloId(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        return pessoa;
    }
}
