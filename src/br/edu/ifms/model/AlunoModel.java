/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;

import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Yuri
 */
@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
@Table(name = "alunos")
public class AlunoModel extends Pessoa {
    private long ra;

    public long getRa() {
        return ra;
    }

    public void setRa(long ra) {
        this.ra = ra;
    }
    
    @Override
    public String toString() {
        return 
            "Nome: "+super.getNome()+"\n"+
            "CPF: "+super.getCpf()+"\n"+
            "Sexo: "+super.getSexo()+"\n"+
            "RA: "+ra+"\n";
    }
}
