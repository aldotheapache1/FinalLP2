/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.dao.CursoDao;
import br.edu.ifms.model.CursoModel;
import br.edu.ifms.view.CursoView;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gian
 */
public class CursoController {
    CursoDao cursos = new CursoDao();
    CursoView cursoView = new CursoView();
    
    public void salvar(){
        try{
            cursos.salvarBD(cursoView.cadastrar());
           sucesso("Curso adicionado");
        }catch(Exception erro){
            erro(erro);
        }
    }
    
    public void exibirTodos() throws SQLException{

            List<CursoModel> lista = cursos.buscarTodosBD();
            for(CursoModel aluno : lista){
                cursoView.exibirDados(aluno);
            }
     
    }
    
    public void exibirCurso() throws SQLException{
    
            cursoView.exibirDados(cursos.buscarCursoPorIdBD(cursoView.buscar()));
       
    }
    
    public void remover() throws SQLException{
        try{
            cursos.removerBD(cursoView.alterar(cursos.buscarCursoPorIdBD(cursoView.remover())));
            sucesso("Curso Removido");
        }catch(Exception e){
            erro(e);
        }
    }
    
    public void alterar(){
        try{
            cursos.alterarBD(cursoView.alterar(cursos.buscarCursoPorIdBD(cursoView.buscar())));
            sucesso("Curso alterado");
        }catch(Exception erro){
            erro(erro);
        }
    }
    
    public void erro(Exception mensagem){
        JOptionPane.showMessageDialog(null, mensagem.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public void sucesso(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
}
