/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileapplication;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Gatinho implements Serializable {
    private String nome;
    private String raca;
    private int age;

    public Gatinho(String nome, String raca, int age) {
        this.nome = nome;
        this.raca = raca;
        this.age = age;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}
