package com.leomoreiradev.pessoaservicehexagonal.transportlayers;

import com.leomoreiradev.pessoaservicehexagonal.entities.Pessoa;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.openapi.model.PessoaRequest;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.openapi.model.PessoaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {
    PessoaResponse pessoaToPessoaResponse(Pessoa pessoa);
    Pessoa pessoaRequestToPessoa(PessoaRequest pessoaRequest);
}
