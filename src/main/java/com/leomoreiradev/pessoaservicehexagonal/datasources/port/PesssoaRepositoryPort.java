package com.leomoreiradev.pessoaservicehexagonal.datasources.port;

import com.leomoreiradev.pessoaservicehexagonal.entities.Pessoa;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.openapi.model.PessoaRequest;

import java.util.List;

public interface PesssoaRepositoryPort {
    List<Pessoa> listarPessoas();
    Pessoa buscarPessoaPeloId(Long id);

    Pessoa criarPessoa(PessoaRequest pessoaRequest);
}
