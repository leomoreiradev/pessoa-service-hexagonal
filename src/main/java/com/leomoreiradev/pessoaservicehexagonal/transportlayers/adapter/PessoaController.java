package com.leomoreiradev.pessoaservicehexagonal.transportlayers.adapter;

import com.leomoreiradev.pessoaservicehexagonal.entities.Pessoa;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.PessoaMapper;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.openapi.model.PessoaRequest;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.port.PessoaServicePort;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.openapi.api.PessoasApi;
import com.leomoreiradev.pessoaservicehexagonal.transportlayers.openapi.model.PessoaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Inherited;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/")
public class PessoaController implements PessoasApi {

    private final PessoaServicePort pessoaServicePort;

    private final PessoaMapper pessoaMapper;



    public PessoaController(PessoaServicePort pessoaServicePort, PessoaMapper pessoaMapper) {
        this.pessoaServicePort = pessoaServicePort;
        this.pessoaMapper = pessoaMapper;
    }

    @Override
    public ResponseEntity<List<PessoaResponse>> buscarPessoas() {
        return ResponseEntity.ok(pessoaServicePort.listarPessoas()
                .stream()
                .map(pessoa -> pessoaMapper.pessoaToPessoaResponse(pessoa))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<PessoaResponse> buscarPessoaPeloId(Long id) {
        return ResponseEntity.ok(pessoaMapper.pessoaToPessoaResponse(pessoaServicePort.buscarPessoaPeloId(id)));
    }


    @Override
    public ResponseEntity<PessoaResponse> criarPessoa(PessoaRequest pessoaRequest) {
        return ResponseEntity.ok(pessoaMapper.pessoaToPessoaResponse(pessoaServicePort.criarPessoa(pessoaRequest)));
    }

}
