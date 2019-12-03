/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Yuri
 */
@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
@Table(name = "alunos")
public class AlunoModel extends Pessoa {
    private long ra;
    
    @ManyToOne
    @JoinColumn(name = "curso", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private CursoModel curso;

    public long getRa() {
        return ra;
    }

    public void setRa(long ra) {
        this.ra = ra;
    }
    
    public CursoModel getCurso() {
        return curso;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
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
