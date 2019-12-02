/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.dao.ProfessorDao;
import br.edu.ifms.model.ProfessorModel;
import br.edu.ifms.view.ProfessorView;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class ProfessorController {
    ProfessorDao professores = new ProfessorDao();
    ProfessorView professorView = new ProfessorView();
    
    public void salvar() throws SQLException{
       try{
            professores.salvarBD(professorView.cadastrar());
            sucesso("Professor salvo");
        }catch(Exception e){
            erro(e);
        }
    }
    
    public void exibirTodos() throws SQLException{
        List<ProfessorModel> lista = professores.buscarTodosBD();
        for(ProfessorModel professor : lista){
            professorView.exibirDados(professor);
        }
    }
    
    public void exibirProfessor() throws SQLException{
        professorView.exibirDados(professores.buscarPorSiapeBD(professorView.buscar()));
    }
    
        public void alterar() throws SQLException{
        try{
            professores.alterarBD(professorView.alterar(professores.buscarPorSiapeBD(professorView.buscar())));
            sucesso("Professor alterado");
        }catch(Exception e){
            erro(e);
        }
    }
    
    public void remover() throws SQLException{
        professores.removerBD(professorView.remover());
    }
    
    public void erro(Exception mensagem){
        JOptionPane.showMessageDialog(null, mensagem.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public void sucesso(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
}
