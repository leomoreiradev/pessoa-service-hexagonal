package com.leomoreiradev.pessoaservicehexagonal.interactors;

import com.leomoreiradev.pessoaservicehexagonal.datasources.port.PesssoaRepositoryPort;
import com.leomoreiradev.pessoaservicehexagonal.entities.Pessoa;
import com.leomoreiradev.pessoaservicehexagonal.interactors.stubs.PessoaStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;

/*@MockitoSettings(strictness = Strictness.LENIENT) essa anotação relaxará as regras de stub mockito
em relaçao ao UnnecessaryStubbingException quando se coloca a configuração Mockito.when no setup*/
@ExtendWith(MockitoExtension.class)
class PessoaUseCaseTest {

    @InjectMocks
    private PessoaUseCase pessoaUseCase;

    @Mock
    private PesssoaRepositoryPort pesssoaRepositoryPort;

    private Pessoa pessoa;

    @BeforeEach
    void setUp() {
        pessoa = PessoaStub.criaPessoaStub();
    }


    @Test
    @DisplayName("Testa retorno da lista de pessoas")
    void deveRetornarListaDeUsuarios() {
        Mockito.when(pesssoaRepositoryPort.listarPessoas()).thenReturn(Arrays.asList(pessoa));
        List<Pessoa> listaAtual = pessoaUseCase.listarPessoas();
        Assertions.assertTrue(listaAtual.size() > 0);

        Mockito.verify(pesssoaRepositoryPort, Mockito.times(1)).listarPessoas();
    }

    @Test
    @DisplayName("Testa retorno de sucesso ao buscar pelo ID")
    void deveRetornarPessoaPeloId() {
        Mockito.when(pesssoaRepositoryPort.buscarPessoaPeloId(anyLong())).thenReturn(pessoa);
        Pessoa pessoaExperada = PessoaStub.criaPessoaStub();
        Pessoa pessoaAtual = pessoaUseCase.buscarPessoaPeloId(1L);

        Assertions.assertNotNull(pessoaAtual);
        Assertions.assertEquals(pessoaExperada.getId(), pessoaAtual.getId());

        Mockito.verify(pesssoaRepositoryPort, Mockito.times(1)).buscarPessoaPeloId(1L);
    }
}