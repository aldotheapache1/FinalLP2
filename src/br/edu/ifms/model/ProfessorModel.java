/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "professores")
public class ProfessorModel extends Pessoa {
    private long siape;
    
    @ManyToOne
    @JoinColumn(name = "idArea", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private AreaModel area;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCurso", insertable = true, updatable = true)
    private CursoModel curso;
    
    public long getSiape() {
        return siape;
    }
    public void setSiape(long siape) {
        this.siape = siape;
    }
    
    public AreaModel getArea() {
        return area;
    }
    public void setArea(AreaModel area) {
        this.area = area;
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
            "SIAPE: "+siape+"\n";
    }
}