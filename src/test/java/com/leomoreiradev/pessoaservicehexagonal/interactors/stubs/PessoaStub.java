package com.leomoreiradev.pessoaservicehexagonal.interactors.stubs;

import com.leomoreiradev.pessoaservicehexagonal.entities.Pessoa;

public class PessoaStub {
    public static Pessoa criaPessoaStub() {
        return new Pessoa(1L, "Kevin");
    }
}
