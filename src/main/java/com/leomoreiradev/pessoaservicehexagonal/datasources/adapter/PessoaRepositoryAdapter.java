package com.leomoreiradev.pessoaservicehexagonal.datasources.adapter;

import com.leomoreiradev.pessoaservicehexagonal.datasources.port.PesssoaRepositoryPort;
import com.leomoreiradev.pessoaservicehexagonal.datasources.repositories.PessoaRepository;
import com.leomoreiradev.pessoaservicehexagonal.entities.Pessoa;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.PessoaMapper;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.openapi.model.PessoaRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PessoaRepositoryAdapter implements PesssoaRepositoryPort {

    private final PessoaMapper pessoaMapper;

    private final PessoaRepository pessoaRepository;

    public PessoaRepositoryAdapter(PessoaMapper pessoaMapper, PessoaRepository pessoaRepository) {
        this.pessoaMapper = pessoaMapper;
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

    @Override
    public Pessoa criarPessoa(PessoaRequest pessoaRequest) {
        return pessoaRepository.save(pessoaMapper.pessoaRequestToPessoa(pessoaRequest));
    }
}
