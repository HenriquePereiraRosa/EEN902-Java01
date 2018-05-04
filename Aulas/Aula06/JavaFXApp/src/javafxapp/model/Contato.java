/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author 11.02741-0
 */
public class Contato {
    
    private final StringProperty nome;
    private final StringProperty sobrenome;
    private final StringProperty cidade;
    private final StringProperty estado;
    private final StringProperty cep;
    private final StringProperty dtNasc;

    public Contato(String nome, String sobrenome, String cidade, String estado, String cep, String dtNasc) {
        this.nome = new SimpleStringProperty(nome);
        this.sobrenome = new SimpleStringProperty(sobrenome);
        this.cidade = new SimpleStringProperty(cidade);
        this.estado = new SimpleStringProperty(estado);
        this.cep = new SimpleStringProperty(cep);
        this.dtNasc = new SimpleStringProperty(dtNasc);
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }
    
    public StringProperty nomeProperty() {
        return this.nome;
    }

    public String getSobrenome() {
        return sobrenome.get();
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome.set(sobrenome);
    }
    
    public StringProperty sobrenomeProperty() {
        return this.sobrenome;
    }

    public String getCidade() {
        return cidade.get();
    }

    public void setCidade(String cidade) {
        this.cidade.set(cidade);
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }

    public String getCep() {
        return cep.get();
    }

    public void setCep(String cep) {
        this.cep.set(cep);
    }

    public String getDtNasc() {
        return dtNasc.get();
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc.set(dtNasc);
    }
}
