package com.mycompany.teste;

import com.mycompany.entidades.Pessoa;
import javax.ejb.Local;


@Local
public interface Persists {
    
        public Pessoa buscarPorCPF(String cpf);
}
