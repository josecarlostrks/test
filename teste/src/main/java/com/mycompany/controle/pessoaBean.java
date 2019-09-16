package com.mycompany.controle;

import com.mycompany.entidades.Pessoa;
import com.mycompany.teste.Persists;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;




@Named(value = "pessoaBean")
@SessionScoped
public class pessoaBean implements Serializable{
    
    private Pessoa pessoa = new Pessoa();
    private Pessoa pessoa2 = new Pessoa();
    
    @EJB
    private Persists service;
    
    public pessoaBean() { 
    }
    
    public List<Pessoa> busca(){
        List<Pessoa> list = new ArrayList<>();
        this.pessoa2=service.buscarPorCPF(this.pessoa.getCpf());
        list.add(this.pessoa2);
        return list;
        
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa2() {
        return pessoa2;
    }

    public void setPessoa2(Pessoa pessoa2) {
        this.pessoa2 = pessoa2;
    }
    
    
}
