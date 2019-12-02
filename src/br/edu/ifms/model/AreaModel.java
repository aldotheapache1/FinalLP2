/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Yuri
 */
@Entity
@Table(name = "areas")
public class AreaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 40, nullable = false)
    private String descricao;
    
    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<ProfessorModel> professores;
    
    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<CursoModel> cursos;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public List<ProfessorModel> getProfessores() {
        return professores;
    }
    public void setProfessores(List<ProfessorModel> professores) {
        this.professores = professores;
    }

    public List<CursoModel> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoModel> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return 
                "ID: " + id + "\n"+
                "Descricao: " + descricao + "\n";
    }
}
