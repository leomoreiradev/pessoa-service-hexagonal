package com.leomoreiradev.pessoaservicehexagonal.interactors;

import com.leomoreiradev.pessoaservicehexagonal.datasources.port.PesssoaRepositoryPort;
import com.leomoreiradev.pessoaservicehexagonal.entities.Pessoa;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.openapi.model.PessoaRequest;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.port.PessoaServicePort;

import java.util.List;

public class PessoaUseCase implements PessoaServicePort {

    private final PesssoaRepositoryPort pesssoaRepositoryPort;

    public PessoaUseCase(PesssoaRepositoryPort pesssoaRepositoryPort) {
        this.pesssoaRepositoryPort = pesssoaRepositoryPort;
    }

    @Override
    public List<Pessoa> listarPessoas() {
        return pesssoaRepositoryPort.listarPessoas();
    }

    @Override
    public Pessoa buscarPessoaPeloId(Long id) {
        try {
            Pessoa pessoa = pesssoaRepositoryPort.buscarPessoaPeloId(id);
            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException("Pessoa não encontrada");
        }
    }

    @Override
    public Pessoa criarPessoa(PessoaRequest pessoaRequest) {
        return pesssoaRepositoryPort.criarPessoa(pessoaRequest);
    }
}
